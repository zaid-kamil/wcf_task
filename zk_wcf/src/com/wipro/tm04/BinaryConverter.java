package com.wipro.tm04;

import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Enter a number between 1 and 255: ");
                    int number = scanner.nextInt();

                    if (number < 1 || number > 255) {
                        System.out.println("Please enter a number between 1 and 255");
                        continue;
                    }

                    // Convert to binary and pad with zeros to ensure 8 digits
                    String binaryString = String.format("%8s", Integer.toBinaryString(number))
                            .replace(' ', '0');

                    System.out.println(binaryString);
                    break;

                } catch (Exception e) {
                    System.out.println("Please enter a valid integer");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }
    }
}
