package com.oops;

/*
 * Create a new class called Calculator with the following methods: 
 * 1. A static method called powerInt(int num1,int num2)
 * This method should return num1 to the power num2.
 * 2. A static method called powerDouble(double num1,int num2).
 * This method should return num1 to the power num2.
 * 3. Invoke both the methods and test the functionalities.
 * Hint: Use Math.pow(double,double) to calculate the power.
 */

class Calculator {
    public static int powerInt(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    public static double powerDouble(double num1, int num2) {
        return Math.pow(num1, num2);
    }

    public static void main(String[] args) {
        System.out.println("2^3 = " + powerInt(2, 3));
        System.out.println("2.5^3 = " + powerDouble(2.5, 3));
    }
}