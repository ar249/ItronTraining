package com.example.metrorestconsumerapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Travel {
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

    public Travel(String email, int source, int destination)
    {   this.email = email;
        this.source = source;
        this.destination = destination;
    }


}
