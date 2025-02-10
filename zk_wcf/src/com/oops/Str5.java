package com.oops;

/*
 * Write a java program that accepts a string and returns a new 
 * string without the first and last character of the input string.

 * Example1)
 * i/p:Suman
 * o/p:uma
 */

public class Str5 {
    private static String removeFirstAndLast(String s){
        return s.substring(1, s.length()-1);
    }

    public static void main(String[] args) {
        String str1 = "Suman";
        String str2 = "Rajesh";
        String str3 = "Zaid Kamil";
        String str4 = "Hello";
        System.out.println(removeFirstAndLast(str1));
        System.out.println(removeFirstAndLast(str2));
        System.out.println(removeFirstAndLast(str3));
        System.out.println(removeFirstAndLast(str4));
    }
}
