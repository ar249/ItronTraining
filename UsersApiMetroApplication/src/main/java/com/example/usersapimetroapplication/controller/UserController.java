package com.example.usersapimetroapplication.controller;

import com.example.usersapimetroapplication.entity.Users;
import com.example.usersapimetroapplication.service.serviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    serviceInterface serviceInterface;

    @PostMapping(path = "/adduser")
    public ResponseEntity<Boolean> addUser(@RequestBody Users u)
    {
        boolean res = serviceInterface.addUser(u);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/getuser/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") String id)
    {
       return new ResponseEntity<>(serviceInterface.getUser(id),HttpStatus.OK);
    }

    @PostMapping (path="/verify")
    public ResponseEntity<String> verify(@RequestBody Users u)
    {
        if(serviceInterface.verify(u))
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        else
            return new ResponseEntity<>("Unsuccessful", HttpStatus.OK);
    }

    @GetMapping(path="/balance/{email}")
    public ResponseEntity<Users> getBalance(@PathVariable("email") String email)
    {
        Users u = serviceInterface.getBalance(email);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping(path = "/recharge/{email}/{amt}")
    public ResponseEntity<String> recharge(@PathVariable("email") String email, @PathVariable("amt") int amt) {
        serviceInterface.recharge(email, amt);
        return new ResponseEntity<>("Recharge Successful", HttpStatus.OK);

    }

    @PutMapping(path = "/updateFare/{email}/{fare}")
    public ResponseEntity<String> updateFare(@PathVariable("email") String id, @PathVariable("fare") int fare)
    {
        serviceInterface.updateFare(id,fare);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


}
