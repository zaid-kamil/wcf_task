package com.oops;

/*
 * Given 2 strings, a and b, return a new string of the 
 * form short+long+short, with the shorter string on the 
 * outside and the longer string on the inside.
 * 
 * The strings will not be the same length, but they may be empty (length 0).
 * If input is "hi" and "hello", then output will be "hihellohi".
 */

public class Str6 {
    private static String shortLongShort(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        } else {
            return b + a + b;
        }
    }

    public static void main(String[] args) {
        String a = "bye";
        String b = "hello";
        System.out.println(shortLongShort(a, b));
    }
}
