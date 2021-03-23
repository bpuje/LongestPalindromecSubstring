package com.example.LongestPalindromecSubstring.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "palindromes_db")
public class Palindrome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String word;

    public Palindrome() {
    }

    public Palindrome(String word) {
        this.word = word;
    }
}
