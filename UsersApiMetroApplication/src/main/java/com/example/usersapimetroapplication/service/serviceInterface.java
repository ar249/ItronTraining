package com.example.usersapimetroapplication.service;

import com.example.usersapimetroapplication.entity.Users;

import java.util.Optional;

public interface serviceInterface {
    public Users getBalance(String email);
    public boolean addUser(Users u);
    public boolean verify(Users u);
    public Users getUser(String id);
    public void updateFare(String email, int amt);
}
