package com.example.dictionary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "entries")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "word", nullable = false)
    private String word;

    @Column(name = "wordtype")
    private String wordType;

    @Column(name = "definition", columnDefinition = "longtext", nullable = false)
    private String definition;

}