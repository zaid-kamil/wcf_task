package com.java.fundamentals;


/*
 * Write a program to initialize an integer array 
 * and find the maximum and minimum value of the array.
 */
public class Arr2 {

    public static void main(String[] args) {
        int[] arr = {12, 12, 33, 44, 51};
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
