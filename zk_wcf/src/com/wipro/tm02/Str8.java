package com.oops;

/*
 * Write a Java program that accepts a string (with * in it). 
 * The program should return a new string in which the following 
 * characters are removed-*,the characters that are to the left and right of *

 * Example1)
 * i/p:ab*cd
 * o/p:ad
 */

public class Str8 {
    private static String removeChars(String str) {
        int index = str.indexOf('*');
        if (index == 0) {
            return str.substring(2);
        } else if (index == str.length() - 1) {
            return str.substring(0, str.length() - 2);
        } else {
            return str.substring(0, index - 1) + str.substring(index + 2);
        }
        
    }

    public static void main(String[] args) {
        String str = "ab*cd";
        System.out.println(removeChars(str));
        String str2 = "x*y*z";
        System.out.println(removeChars(str2));
        String str3 = "abc*";
        System.out.println(removeChars(str3));
        String str4 = "*ab";
        System.out.println(removeChars(str4));
    }
}
