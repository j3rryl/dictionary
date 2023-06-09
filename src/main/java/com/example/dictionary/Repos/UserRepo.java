package com.example.dictionary.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dictionary.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
