package com.example.usersapimetroapplication.service;

import com.example.usersapimetroapplication.entity.Users;
import com.example.usersapimetroapplication.persistance.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class serviceImplementation implements serviceInterface {

    @Autowired
    UsersDao usersDao;
    @Override
    public boolean addUser(Users u)
    {
        Optional<Users> ifpresent = usersDao.findById(u.getEmail());
        if(ifpresent.isPresent())
        {
            return false;
        }
    try {
        usersDao.save(u);
        return true;
    }catch (DuplicateKeyException e)
    {
        e.printStackTrace();
    }
    return false;
    }

    @Override
    public Users getUser(String id)
    {
       Optional<Users> uss =  usersDao.findById(id);
       Users u=null;
       if(uss.isPresent())
           u=uss.get();
       return u;
    }

    @Override
    public boolean verify(Users u) {
        String pass = u.getPassword();
        Optional<Users> user = usersDao.findById(u.getEmail());
        if(user.isPresent()){
            if(user.get().getPassword().equals(pass))
            {
                System.out.println("Verification Successful");
                return true;
            }
            else{
                System.out.println("Verification Unsuccessful");
                return false;
            }
        }
        return false;
    }

    public Users getBalance(String email)
    {
        Optional<Users> user = usersDao.findById(email);
        if(user.isPresent())
        {
            return user.get();
        }
        return null;
    }

    public void recharge(String email, int amt)
    {
        Optional<Users> user = usersDao.findById(email);
        if(user.isPresent())
        {
            Users u1 = user.get();
            u1.setBalance(u1.getBalance()+amt);
            usersDao.save(u1);
        }
    }

    @Override
    public void updateFare(String email, int amt) {
        Optional<Users> u = usersDao.findById(email);
        if(u.isPresent())
        {
            Users users = u.get();
            users.setBalance(amt);
            usersDao.save(users);
        }
    }
}
