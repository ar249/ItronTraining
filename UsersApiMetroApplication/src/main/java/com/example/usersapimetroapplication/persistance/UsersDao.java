package com.example.usersapimetroapplication.persistance;

import com.example.usersapimetroapplication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, String> {
}
