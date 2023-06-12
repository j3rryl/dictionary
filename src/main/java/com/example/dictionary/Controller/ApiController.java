package com.example.dictionary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dictionary.Models.ApiResponse;
import com.example.dictionary.Models.User;
import com.example.dictionary.Models.Words;
import com.example.dictionary.Repos.UserRepo;
import com.example.dictionary.Repos.WordsRepo;
import com.example.dictionary.Service.DictionaryService;
import com.example.dictionary.Service.UserService;

@RestController
@RequestMapping("dictionary/api")
@CrossOrigin(origins = "*")

//Research on path vs value
public class ApiController {
    private final UserService userService;
    private final DictionaryService dictionaryService;

    public ApiController(UserService userService, DictionaryService dictionaryService) {
        this.userService = userService;
        this.dictionaryService = dictionaryService;
    }

    //Handles all dependency dependencies
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WordsRepo wordsRepo;

    @GetMapping(value = "")
    public String getPage(){
        return "Welcome to the dictionary API.";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    //Get user by id
    @GetMapping(value = "/user/{id}")
    public String getUser(@PathVariable long id){
        User fetchedUser = userRepo.findById(id).get();
        return "Fetch 1 user: \n"+ fetchedUser;
    }

    //Get users by name
    @GetMapping(value = "/user")
    public List<User> getUsersByName(@RequestParam("firstName") String firstName){
        return userService.getUsersByName(firstName);
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

    //Get users by name
    @GetMapping(value = "/word", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWordsByWord(@RequestParam("word") String searchQuery){
        String notFound = "Can't find the meaning of '" + searchQuery + "'. Please, try to search for another word.";

        // return dictionaryService.getWordsByWord(word);
        List<Words> results = wordsRepo.findByWord(searchQuery.trim());

        if(results.isEmpty()){
            // return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(notFound));
            return ResponseEntity.ok(new ApiResponse(false, notFound));

        } else {
            return ResponseEntity.ok(new ApiResponse(true, results));
        }
    }
}
