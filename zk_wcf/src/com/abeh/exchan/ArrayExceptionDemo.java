package com.abeh.exchan;

import java.util.Scanner;

public class ArrayExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Get array size
            System.out.println("Enter the number of elements in the array");
            int size = Integer.parseInt(scanner.nextLine());
            
            // Create and populate array
            int[] array = new int[size];
            System.out.println("Enter the elements in the array");
            for(int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(scanner.nextLine());
            }
            
            // Get index to access
            System.out.println("Enter the index of the array element you want to access");
            int index = Integer.parseInt(scanner.nextLine());
            
            // Access and print element
            System.out.println("The array element at index " + index + " = " + array[index]);
            System.out.println("The array element successfully accessed");
            
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("java.lang.ArrayIndexOutOfBoundsException");
        } finally {
            scanner.close();
        }
    }
}
