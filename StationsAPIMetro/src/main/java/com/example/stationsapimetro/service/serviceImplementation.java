package com.example.stationsapimetro.service;

import com.example.stationsapimetro.entity.Stations;
import com.example.stationsapimetro.persistance.StationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImplementation implements serviceInterface{

    @Autowired
    StationsDao stationsDao;
    public List<Stations> listStations(){
        List<Stations> list = stationsDao.findAll();
        return list;
    }
}
