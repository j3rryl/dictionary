package com.example.dictionary.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dictionary.Models.Words;

@Repository
public interface WordsRepo extends JpaRepository<Words, Long>{
    List<Words> findByWord(String word);
}
