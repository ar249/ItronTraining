package com.example.metrorestconsumerapplication.service;

import com.example.metrorestconsumerapplication.entity.Stations;
import com.example.metrorestconsumerapplication.entity.Travel;
import com.example.metrorestconsumerapplication.entity.Users;

import java.util.List;

public interface serviceInterface {
    public boolean register(Users u);
    public int generateCard();
    public boolean verify(Users u);
    public int balance(String email);
    public String recharge (String email, int amt);
    public List<Stations> getStations();
    public String fare(Travel t);
    public boolean userPresent(String email);
}
