package com.example.travelapemetroapplication.persistence;

import com.example.travelapemetroapplication.entity.Travel;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface TravelDao extends JpaRepository<Travel, Integer> {
}
