package com.example.LongestPalindromecSubstring.controller;

import com.example.LongestPalindromecSubstring.model.ApiResponse;
import com.example.LongestPalindromecSubstring.model.Palindrome;
import com.example.LongestPalindromecSubstring.service.IPalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

    private final IPalindromeService palindromeService;

    @Autowired
    public PalindromeController(IPalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Palindrome>>> getAllPalindrome(){
        ApiResponse<List<Palindrome>> response = new ApiResponse<>();
        try{
            List<Palindrome> palindromes = palindromeService.getAllPalindromes();
            response.setData(palindromes);
            response.setMessage("List of Palindromes");
        } catch(Exception e){
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/store")
    public ResponseEntity<ApiResponse<Palindrome>> storeLongestPalSubstring(@RequestBody Palindrome palindromeData) throws Exception {
        ApiResponse<Palindrome> response = new ApiResponse<>();
        try {
            Palindrome palindrome = palindromeService.storePalindromeString(palindromeData);
            response.setData(palindrome);
            response.setMessage("Palindrome Strings are successfully stored.");
        } catch (Exception e) {
            response.setStatus(500);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
