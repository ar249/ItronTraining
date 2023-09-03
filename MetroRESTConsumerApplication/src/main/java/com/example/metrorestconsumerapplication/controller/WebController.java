package com.example.metrorestconsumerapplication.controller;

import com.example.metrorestconsumerapplication.entity.Travel;
import com.example.metrorestconsumerapplication.entity.Users;
import com.example.metrorestconsumerapplication.service.serviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.metrorestconsumerapplication.entity.Stations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    serviceInterface serviceInterface;

    @GetMapping(path = "/")
    public ModelAndView homePage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(path = "/register" )
    public ModelAndView addUser()
    {
        return new ModelAndView("register","usr",new Users());
    }

    @RequestMapping(path = "/thankYou" )
    public ModelAndView thankYou()
    {
        return new ModelAndView("thankYou");
    }

    @PostMapping(path = "/add")
    public ModelAndView register(@ModelAttribute("usr") Users u)
    {   ModelAndView modelAndView = new ModelAndView();
        String message = "";
        if(u.getEmail()==""||u.getPassword()==""||u.getName()==""){
            ModelAndView modelAndView1 = new ModelAndView();
            message = "Please Fill All Details !!!";
            modelAndView1.addObject("msg",message);
            modelAndView1.setViewName("register");
            return modelAndView1;
        }
        if(serviceInterface.register(u))
           {message = "Successfully Registered , Please Login to continue !!";
            modelAndView.addObject("msg",message);
            modelAndView.setViewName("index");}
           else {
               message = "Already Registered!! Please Login to continue !!";
               modelAndView.addObject("msg",message);
               modelAndView.setViewName("index");
           }
         return modelAndView;
    }

    @GetMapping(path="/login")
    public ModelAndView login()
    {
        return new ModelAndView("login","usr",new Users());
    }

    @PostMapping (path="/verify")
    public ModelAndView verify(@ModelAttribute Users u, HttpSession session)
    { ModelAndView modelAndView = new ModelAndView();
        String msg="";
        if(u.getEmail().equals("")||u.getPassword().equals(""))
        {
            msg = "Please Fill All details !!";
            return new ModelAndView("login","usr",new Users()).addObject("msg",msg);
        }
        if(serviceInterface.verify(u)) {
            msg = "Welcome " + u.getEmail() + " !";
            session.setAttribute("id",u.getEmail());
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("userMenu");
        }
        else
        {   if(serviceInterface.userPresent(u.getEmail()))
        {
            msg = "Incorrect Password, Try Again !!";
            return new ModelAndView("login","usr",new Users()).addObject("msg",msg);
        }
            msg = "User Not Registered, Please Register to continue !!!";
            return new ModelAndView("login","usr",new Users()).addObject("msg",msg);
        }
        return modelAndView;
    }

    @GetMapping(path="/balance")
    public ModelAndView getBalance(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
       int bal = serviceInterface.balance(session.getAttribute("id").toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bal",bal);
        modelAndView.setViewName("balanceEnquiry");
        return modelAndView;
    }

    @RequestMapping("/userMenu")
    public ModelAndView showUserMenu()
    {
        return new ModelAndView("userMenu");
    }

    @RequestMapping("/mainMenu")
    public ModelAndView showMainMenu()
    {
        return new ModelAndView("index");
    }

    @PostMapping(path = "/calculate")
    public ModelAndView calculateFare(@ModelAttribute Travel t, HttpServletRequest request)
    {   String msg="";
        while(t.getDestination()==t.getSource())
    {  msg = "Source and Destination cant be same !!!";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.addObject("stationList",request.getSession().getAttribute("stationsList"));
        modelAndView.setViewName("stationEntry");
        return modelAndView;
    }
        HttpSession session = request.getSession();
        String email = session.getAttribute("id").toString();

         ModelAndView modelAndView = new ModelAndView();
         Travel travel = new Travel(email, t.getSource(),t.getDestination());
         msg = serviceInterface.fare(travel);
         modelAndView.addObject("msg",msg);
         modelAndView.setViewName("userMenu");
         return modelAndView;
    }

    @GetMapping(path = "/listStations")
    public ModelAndView getStations(HttpSession session)
    {
         List<Stations> stationsList = serviceInterface.getStations();
         session.setAttribute("stationsList",stationsList);
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("stationList",stationsList);
         modelAndView.addObject("travel",new Travel());
         modelAndView.setViewName("stationEntry");
         return modelAndView;
    }

    @GetMapping(path = "/recharge")
    public ModelAndView recharge()
    { return new ModelAndView("recharge");
    }

    @GetMapping(path="/addbal")
    public ModelAndView rechargeDone(@RequestParam("amount")int amt, HttpSession session)
    {
        String msg = "";
        if(amt<=0)
    {
        msg = "Please enter a valid amount";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("recharge");
        return modelAndView;
    }
       String str = serviceInterface.recharge(session.getAttribute("id").toString(),amt);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("msg",str);
       modelAndView.setViewName("userMenu");
       return modelAndView;
    }
}
