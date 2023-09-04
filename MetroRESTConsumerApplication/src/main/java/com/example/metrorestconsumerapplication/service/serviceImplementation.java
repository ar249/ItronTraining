package com.example.metrorestconsumerapplication.service;

import com.example.metrorestconsumerapplication.entity.Stations;
import com.example.metrorestconsumerapplication.entity.Travel;
import com.example.metrorestconsumerapplication.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


@Service
public class serviceImplementation implements serviceInterface{

    @Autowired
    private RestTemplate restTemplate;

    public int generateCard()
    {   int max = 1234567;
        int min = 11;
        int num = (int)Math.floor(Math.random() *(max - min + 1) + min);
        return num;
    }

    public boolean register(Users u)
    {  u.setCard_id(generateCard());
        u.setBalance(100);
        try{
            ResponseEntity<Boolean> bool = restTemplate.postForEntity("http://localhost:8082/adduser",u,Boolean.class);
            if(bool.getBody()==false)
                return false;
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       return false;
    }

    public boolean verify(Users u)
    {
      ResponseEntity<String> res =  restTemplate.postForEntity("http://localhost:8082/verify",u,String.class);
      if(res.getBody().equals("Successful"))
            return true;
        return false;
    }

    public int balance(String email)
    {
      Users u =  restTemplate.getForObject("http://localhost:8082/getuser/"+email,Users.class);
        return u.getBalance();
    }

    public void recharge(String email, int amt)
    {
      restTemplate.put("http://localhost:8082/recharge/"+email+"/"+amt,String.class);

    }

    public List<Stations> getStations()
    {
        Stations []stations = restTemplate.getForObject("http://localhost:8080/liststations",Stations[].class);
        List<Stations> stationsList = Arrays.asList(stations);
        return stationsList;
    }

    @Override
    public String fare(Travel t) {
        String email = t.getEmail();
        String msg="";
        Users u =  restTemplate.getForObject("http://localhost:8082/getuser/"+email,Users.class);
        if(!u.getEmail().equals(""))
        {
            int a = t.getDestination();
            int b = t.getSource();
            int charge = Math.abs(a-b)*5;
            if(balance(email)-charge>=20){
            t.setFare(charge);
            t.setTravel_id(0);
            int rem = balance(email)-charge;
            ResponseEntity<String> res= restTemplate.postForEntity("http://localhost:8081/travel",t,String.class);
            restTemplate.put("http://localhost:8082/updateFare/"+email+"/"+rem,String.class);
            msg = "Travel Successful, Fare : " + charge + " Rem Bal : "+ rem;
            return msg;
            }
            else
                return "Not Sufficient Bal, Please Recharge !!!";
        }
        return msg;
    }

    public boolean userPresent(String email)
    {   if(email.equals(""))
        return false;
        Users u =  restTemplate.getForObject("http://localhost:8082/getuser/"+email,Users.class);
        return u!=null;
    }
}

