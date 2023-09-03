package com.example.stationsapimetro.persistance;

import com.example.stationsapimetro.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsDao extends JpaRepository<Stations, Integer> {
}
