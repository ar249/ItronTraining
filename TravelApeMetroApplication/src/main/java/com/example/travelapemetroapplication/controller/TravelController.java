package com.example.travelapemetroapplication.controller;

import com.example.travelapemetroapplication.entity.Travel;
import com.example.travelapemetroapplication.service.serviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

    @Autowired
    serviceInterface serviceInterface;

    @PostMapping(path = "/travel")
    public ResponseEntity<String> addTravel(@RequestBody Travel t)
    {
        serviceInterface.addTravel(t);
        return new ResponseEntity<>("Travel Successful", HttpStatus.OK);
    }
}
