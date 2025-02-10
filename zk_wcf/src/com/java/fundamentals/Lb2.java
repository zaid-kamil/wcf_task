package com.java.fundamentals;

/*
 * Write a Program to accept a String as a command line 
 * argument and print a Welcome message as given below.
 * 
 * Example1)
 * C:\> java Sample John
 * O/P Expected : Welcome John
 */

/**
 *
 * @author zaid kamil
 */
public class Lb2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
        } else {
            System.out.println("Welcome " + args[0]);
        }
    }
}
