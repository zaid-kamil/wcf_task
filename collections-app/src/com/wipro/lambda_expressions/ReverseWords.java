package com.wipro.lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseWords {
    public static void main(String[] args) {
        // Create ArrayList and add 10 words
        ArrayList<String> al = new ArrayList<>();
        al.add("Hello");
        al.add("World");
        al.add("Java");
        al.add("Programming");
        al.add("Lambda");
        al.add("Expression");
        al.add("ArrayList");
        al.add("String");
        al.add("Collections");
        al.add("Reverse");

        // Print original list
        System.out.println("Original List:");
        al.forEach(word -> System.out.println(word));

        // Sort in reverse order using lambda
        System.out.println("\nReversed List:");
        Collections.sort(al, (s1, s2) -> s2.compareTo(s1));
        al.forEach(word -> System.out.println(word));
    }
}
