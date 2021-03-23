package com.example.LongestPalindromecSubstring.service;

import com.example.LongestPalindromecSubstring.model.Palindrome;

import java.util.List;

public interface IPalindromeService {

    Palindrome storePalindromeString(Palindrome palindrome) throws Exception;

    List<Palindrome> getAllPalindromes() throws Exception;
}
