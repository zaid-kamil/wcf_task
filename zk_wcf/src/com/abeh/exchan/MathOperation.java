package com.abeh.exchan;

public class MathOperation {
    public static void main(String[] args) {
        try {
            // Check if exactly 5 arguments are provided
            if (args.length != 5) {
                throw new IllegalArgumentException("Please provide exactly 5 integer arguments");
            }

            // Create array and parse command line arguments
            int[] numbers = new int[5];
            for (int i = 0; i < 5; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }

            // Calculate sum
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            // Calculate average
            double average = (double) sum / numbers.length;

            // Display results
            System.out.println("Sum of the array elements: " + sum);
            System.out.println("Average of the array elements: " + average);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
