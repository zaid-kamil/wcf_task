package com.java.fundamentals;

/* Write a Program to accept two integers as command 
 * line arguments and print the sum of the two numbers
 * 
 * Example1)
 * C:\>java Sample 10 20
 * O/P Expected : The sum of 10 and 20 is 30
 * 
 */

public class Lb3 {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Please provide two integers as arguments");
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int sum = a + b;
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }
}
