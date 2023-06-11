package com.example.dictionary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dictionary.Models.User;
import com.example.dictionary.Models.Words;
import com.example.dictionary.Repos.UserRepo;
import com.example.dictionary.Repos.WordsRepo;

@Controller
public class IndexController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WordsRepo wordsRepo;

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

    @GetMapping("/home")
    public String homePage(Model model){
        // model.addAttribute("results", results);
        return "home";
    }

    @PostMapping("/home")
    public String search(@RequestParam("searchWord") String searchWord, Model model){
        List<Words> results = wordsRepo.findByWord(searchWord.trim());
        String notFound="Can't find the meaning of '" + searchWord + "'. Please, try to search for another word";
        if(results.isEmpty()){
            model.addAttribute("emptyArray", true);
            model.addAttribute("notFound", notFound);
        } else {
            model.addAttribute("emptyArray", false);
            model.addAttribute("results", results);
        }
        return "home";
    }
}
