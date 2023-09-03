package com.example.metrorestconsumerapplication.entity;


import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Data
@ToString
@Ignore
public class Users {
    private String email;
    private String name;
    private String password;
    private int card_id;
    private int balance;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String email, String name, String password, int card_id, int balance) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.card_id = card_id;
        this.balance = balance;
    }
}

