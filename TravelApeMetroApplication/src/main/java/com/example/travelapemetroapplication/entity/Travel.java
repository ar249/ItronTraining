package com.example.travelapemetroapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Travel {
    @Id
    private int travel_id;
    private String email;
    private int source;
    private int destination;
    private int fare;

    public Travel(String email, int source, int destination, int fare)
    {
        this.email = email;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }
}
