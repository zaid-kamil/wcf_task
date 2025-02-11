package com.java.fundamentals;

/*
 * Write a Java program to find if the given number is palindrome or not
 * Example1)
 * C:\>java Sample 110011
 * O/P: 110011 is a palindrome
 * 
 * Example2)
 * C:\>java Sample 1234
 * O/P: 1234 is not a palindrome
 * 
 */

public class Fcs17 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }
        int num = Integer.parseInt(args[0]);
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome");
        } else {
            System.out.println(num + " is not a palindrome");
        }
    } 

    private static boolean isPalindrome(int num) {
        int reversed = 0;
        int original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }
}
