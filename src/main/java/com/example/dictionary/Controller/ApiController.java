package com.example.dictionary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dictionary.Models.User;
import com.example.dictionary.Repos.UserRepo;

@RestController
public class ApiController {

    //Handles all dependency dependencies
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        //Because it is json hence te @RequestBody
        userRepo.save(user);
        return "Saved";
    }
}
