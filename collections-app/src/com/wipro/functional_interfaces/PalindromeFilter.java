package com.wipro.functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PalindromeFilter {

    // Utility method to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        if (word == null) return false;
        StringBuilder sb = new StringBuilder(word);
        return word.equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        // Create an ArrayList with 10 words
        ArrayList<String> words = new ArrayList<>();
        words.add("radar");
        words.add("hello");
        words.add("civic");
        words.add("world");
        words.add("level");
        words.add("java");
        words.add("madam");
        words.add("openai");
        words.add("refer");
        words.add("deified");

        // Define the predicate to filter palindrome words
        Predicate<String> palindromePredicate = word -> isPalindrome(word);

        // Filter the words using the predicate
        List<String> palindromes = words.stream()
                .filter(palindromePredicate)
                .collect(Collectors.toList());

        // Print the resulting palindrome words
        System.out.println("Palindromes: " + palindromes);
    }
}