package com.example.dictionary.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dictionary.Models.Words;

public interface WordsRepo extends JpaRepository<Words, Long>{
    
}
