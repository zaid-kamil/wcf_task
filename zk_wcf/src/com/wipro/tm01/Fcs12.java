package com.java.fundamentals;

/*
 * Write a program to check if a given number is prime or not.
 */
public class Fcs12 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }
        int num = Integer.parseInt(args[0]);
        if (num <= 1) {
            System.out.println("Not Prime");
            return;
        }
        System.out.println(isPrime(num) ? "Prime" : "Not Prime");
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
