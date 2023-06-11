package com.example.dictionary.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dictionary.Models.User;
import com.example.dictionary.Repos.UserRepo;

@Controller
public class IndexController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user){
        User adduser = new User("Jacob", "Kanyi", 23, "Student");
        userRepo.save(adduser);
        return "redirect:/dynamic";
        // return "New user added";
    }

    @GetMapping("/dynamic")
    public String dynamic(Model model){
        model.addAttribute("employees", userRepo.findAll());
        return "dynamic";
    }
}
