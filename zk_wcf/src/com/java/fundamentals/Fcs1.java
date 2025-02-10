package com.java.fundamentals;

/*
 * A) Write a program to check if a given integer number 
 * is Positive, Negative, or Zero. 
 * 
 * B) Given two non-negative int values, print true if 
 * they have the same last digit, such as with 27 and 57. 
 * 
 * lastDigit(7, 17) → true
 * lastDigit(6, 17) → false
 * lastDigit(3, 113) → true
 * 
 */

class Fcs1 {
    public static void main(String[] args) {
        Fcs1 fcs1 = new Fcs1();
        switch (args.length) {
            case 0:
                System.out.println("No arguments provided");
                return;
            case 1:
                fcs1.checkNum(Integer.parseInt(args[0]));
                break;
            case 2:
                int first = Integer.parseInt(args[0]);
                int second = Integer.parseInt(args[1]);
                System.out.println(fcs1.lastDigit(first, second));
                break;
            default:
                break;
        }

    }

    private void checkNum(int num){
        if (num > 0) {
            System.out.println("Positive");
        } else if (num < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public boolean lastDigit(int a, int b){
        return a % 10 == b % 10;
    }
}