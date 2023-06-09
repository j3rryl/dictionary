package com.example.dictionary.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dictionary.Models.User;
import com.example.dictionary.Repos.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}

