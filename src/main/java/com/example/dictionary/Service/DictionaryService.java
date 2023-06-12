package com.example.dictionary.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dictionary.Models.Word;
import com.example.dictionary.Repos.WordsRepo;

@Service
public class DictionaryService {
    private final WordsRepo wordsRepo;

    public DictionaryService(WordsRepo wordsRepo) {
        this.wordsRepo = wordsRepo;
    }

    public List<Word> getWordsByWord(String word) {
        return wordsRepo.findByWord(word);
    }
}

