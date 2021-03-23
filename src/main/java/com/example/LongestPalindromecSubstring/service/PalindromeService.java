package com.example.LongestPalindromecSubstring.service;

import com.example.LongestPalindromecSubstring.model.Palindrome;
import com.example.LongestPalindromecSubstring.repository.PalindromeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalindromeService implements IPalindromeService {

    private final PalindromeRepository repository;

    @Autowired
    public PalindromeService(PalindromeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Palindrome storePalindromeString(Palindrome s) {
        // Max len of substring and its start pos
        Palindrome result;
        int max = 0, start = 0;
        String str = s.getWord();
        // Expand from every possible centers
        for (int i = 0; i < str.length(); i++) {
            int len1 = expand(str, i, i);
            int len2 = expand(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > max) {
                max = len;
                start = i - (len - 1) / 2;
            }
        }
        result = new Palindrome(str.substring(start, start + max));
        return repository.save(result);
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


    @Override
    public List<Palindrome> getAllPalindromes() throws Exception {
        return repository.findAll();
    }

}
