package com.example.dictionary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dictionary.Models.User;
import com.example.dictionary.Models.Words;
import com.example.dictionary.Repos.UserRepo;
import com.example.dictionary.Repos.WordsRepo;

@RestController
public class ApiController {

    //Handles all dependency dependencies
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WordsRepo wordsRepo;

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

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        //Because it is json hence te @RequestBody
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());

        userRepo.save(updatedUser);
        return "User Updated";
    }

    //All dictionary words
    @GetMapping(value = "/dictionary")
    public List<Words> getDictionary(){
        return wordsRepo.findAll();
    }

    @GetMapping("/dictionary")
    public List<Words> getNames(@RequestParam("word") String word) {
        return wordsRepo.findByWord(word);
    }
}
