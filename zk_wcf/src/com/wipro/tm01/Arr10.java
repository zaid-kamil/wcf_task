package com.java.fundamentals;


/*
 * Print an array that contains the exact same numbers as the 
 * given array, but rearranged so that all the even numbers
 * come before all the odd numbers. Other than that, the 
 * numbers can be in any order. You may modify and print the 
 * given array, or make a new array.
 * 
 * evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
 * evenOdd([3, 3, 2]) → [2, 3, 3]
 * evenOdd([2, 2, 2]) → [2, 2, 2]
 */

public class Arr10 {
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 1, 0, 0, 1, 1};
        int[] arr2 = {3, 3, 2};
        int[] arr3 = {2, 2, 2};
        printArray(evenOdd(arr1));
        printArray(evenOdd(arr2));
        printArray(evenOdd(arr3));
    }

    public static int[] evenOdd(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                newArr[j] = arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

