package com.wipro.functional_interfaces;

import java.util.ArrayList;
import java.util.function.Consumer;

public class OddEvenChecker {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // Adding 10 numbers to the ArrayList
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Consumer to check and print if a number is odd or even
        Consumer<Integer> checkOddEven = number -> {
            if (number % 2 == 0) {
                System.out.println(number + " even");
            } else {
                System.out.println(number + " odd");
            }
        };

        // Applying the Consumer to each number in the ArrayList
        numbers.forEach(checkOddEven);
    }
}