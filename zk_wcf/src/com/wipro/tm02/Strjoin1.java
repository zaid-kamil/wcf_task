package com.oops;

import java.util.ArrayList;
import java.util.StringJoiner;

/*
 * Given an ArrayList containing n names, use StringJoiner 
 * to construct a new sequence of names separated by , 
 * (comma) and enclosed in { } brackets.
 */

public class Strjoin1 {
    public static void main(String[] args) {
        // create an ArrayList
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Doe");
        names.add("Jane");
        names.add("Smith");
        names.add("Alice");
        names.add("Bob");

        // create a StringJoiner
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }
}
