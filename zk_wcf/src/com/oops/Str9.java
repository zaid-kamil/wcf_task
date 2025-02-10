package com.oops;

/*
 * Given two strings, a and b, print a new string which is made 
 * of the following combination-first character of a, the first 
 * character of b, second character of a, second character of b 
 * and so on. 
 * Any characters left, will go to the end of the result.
 * 
 * Example1)
 * i/p:Hello,World
 * o/p:HWeolrllod
 */

public class Str9 {
    private static String mixString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < a.length() && i < b.length()) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
            i++;
        }
        if (i < a.length()) {
            sb.append(a.substring(i));
        } else if (i < b.length()) {
            sb.append(b.substring(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        System.out.println(mixString(a, b));
    }
}


