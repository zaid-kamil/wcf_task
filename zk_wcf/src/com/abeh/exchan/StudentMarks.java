package com.abeh.exchan;

import java.util.Scanner;

public class StudentMarks {
    public static void validateMarks(int marks) throws NegativeValueException, OutOfRangeException {
        if (marks < 0) {
            throw new NegativeValueException("Marks cannot be negative");
        }
        if (marks > 100) {
            throw new OutOfRangeException("Marks cannot be greater than 100");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            for (int student = 1; student <= 2; student++) {
                System.out.println("\nEnter details for student " + student + ":");
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                
                int totalMarks = 0;
                
                for (int subject = 1; subject <= 3; subject++) {
                    System.out.print("Enter marks for subject " + subject + ": ");
                    try {
                        int marks = Integer.parseInt(scanner.nextLine());
                        validateMarks(marks);
                        totalMarks += marks;
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Marks must be an integer value");
                    } catch (NegativeValueException | OutOfRangeException e) {
                        throw e;
                    }
                }
                
                double average = totalMarks / 3.0;
                System.out.println(name + "'s average marks: " + String.format("%.2f", average));
            }
            
        } catch (NumberFormatException | NegativeValueException | OutOfRangeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
