package com.example.dictionary.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dictionary.Models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);
    
}
