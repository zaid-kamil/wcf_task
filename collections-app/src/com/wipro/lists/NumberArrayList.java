package com.wipro.lists;

import java.util.ArrayList;

public class NumberArrayList {
    private ArrayList<Number> numbers;

    public NumberArrayList() {
        numbers = new ArrayList<>();
    }

    // Add a number to the list
    public void addNumber(Number num) {
        numbers.add(num);
    }

    // Print all numbers
    public void printNumbers() {
        System.out.println("Numbers in the list:");
        for (Number num : numbers) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        NumberArrayList numList = new NumberArrayList();

        // Adding different types of numbers
        numList.addNumber(10);          // Integer
        numList.addNumber(20.5f);       // Float
        numList.addNumber(30.75d);      // Double
        numList.addNumber(40L);         // Long
        numList.addNumber(50.25);       // Double
        
        // Print all numbers
        numList.printNumbers();
        
        // This won't compile - demonstrates type safety:
        // numList.addNumber("String");  // Error: String cannot be converted to Number
        // numList.addNumber(true);      // Error: boolean cannot be converted to Number
    }
}