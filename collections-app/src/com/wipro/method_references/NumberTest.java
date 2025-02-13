package com.wipro.method_references;

public class NumberTest {
    private final int number;

    // Parameterized constructor that checks for prime
    public NumberTest(int number) {
        this.number = number;
        if (isPrime(number)) {
            System.out.println(number + " is Prime");
        } else {
            System.out.println(number + " is Not Prime");
        }
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Using constructor reference to create PrimeChecker instance
        PrimeChecker checker = NumberTest::new;

        // Test with different numbers
        System.out.println("Testing different numbers:");
        checker.check(7);    // Prime
        checker.check(15);   // Not Prime
        checker.check(23);   // Prime
        checker.check(1);    // Not Prime
        checker.check(0);    // Not Prime
        checker.check(-5);   // Not Prime
    }
}