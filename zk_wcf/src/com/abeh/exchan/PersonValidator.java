package com.abeh.exchan;

public class PersonValidator {
    public static void validateAge(int age) throws AgeValidationException {
        if (age < 18) {
            throw new AgeValidationException("Age should be greater than or equal to 18");
        } else if (age >= 60) {
            throw new AgeValidationException("Age should be less than 60");
        }
    }

    public static void main(String[] args) {
        try {
            // Check if correct number of arguments are passed
            if (args.length != 2) {
                throw new IllegalArgumentException("Please provide both name and age");
            }

            String name = args[0];
            int age = Integer.parseInt(args[1]);

            // Validate age
            validateAge(age);

            // If validation passes, display success message
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Validation successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be a valid number");
            System.exit(1);
        } catch (AgeValidationException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
