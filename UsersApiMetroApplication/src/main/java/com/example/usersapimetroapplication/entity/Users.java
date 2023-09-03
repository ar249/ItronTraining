package com.example.usersapimetroapplication.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@ToString
@Ignore
@Entity
public class Users {
    @Id
    private String email;
    private String name;
    private String password;
    private int card_id;
    private int balance;

    public Users(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public Users(String email, String name, String password, int card_id,int balance)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.card_id = card_id;
        this.balance = balance;
    }

}