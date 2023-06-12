package com.example.dictionary.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dictionary.Models.Word;

@Repository
public interface WordsRepo extends JpaRepository<Word, Long>{
    List<Word> findByWord(String word);
}
