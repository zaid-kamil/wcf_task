package com.oops;

/*
 * Given a string and an integer n, print a new string made of n 
 * repetitions of the last n characters of the string. 
 * You may assume that n is between 0 and the length of the string, inclusive. 
 * 
 * Example1)
 * i/p:Wipro,3
 * o/p:propropro
 */

public class Str10 {
    private static String repeatEnd(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str.substring(str.length() - n));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Str10 <string>,<n>");
            System.exit(1);
        }
        // split
        String[] input = args[0].split(",");
        String str = input[0];
        int n = Integer.parseInt(input[1]);
        if (n < 0 || n > str.length()) {
            System.out.println("n should be between 0 and the length of the string, inclusive.");
            System.exit(1);
        }
        System.out.println(repeatEnd(str, n));
    }
}
