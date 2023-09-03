package com.example.travelapemetroapplication.service;

import com.example.travelapemetroapplication.entity.Travel;
import com.example.travelapemetroapplication.persistence.TravelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviceImplementation implements serviceInterface{

    @Autowired
    TravelDao travelDao;

    public void addTravel(Travel t)
    {   travelDao.save(t);
    }
}
