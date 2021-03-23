package com.example.LongestPalindromecSubstring.repository;

import com.example.LongestPalindromecSubstring.model.Palindrome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Integer> {
}
