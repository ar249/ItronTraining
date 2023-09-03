package com.example.stationsapimetro.controller;

import com.example.stationsapimetro.entity.Stations;
import com.example.stationsapimetro.service.serviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    serviceInterface serviceInterface;

    @RequestMapping("/liststations")
    public ResponseEntity<List<Stations>> getStationList(){
        List<Stations> stationsList = serviceInterface.listStations();
        return new ResponseEntity<>(stationsList, HttpStatus.OK);
    }
}
