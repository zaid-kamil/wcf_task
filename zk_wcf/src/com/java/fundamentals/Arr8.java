package com.java.fundamentals;

/*
 * Write a program to print the sum of the elements of an 
 * array following the given below condition.
 * 
 * If the array has 6 and 7 in succeeding orders, ignore the 
 * numbers between 6 and 7 and consider the other numbers for calculation of sum.
 * 
 * Eg1) Array Elements - 10,3,6,1,2,7,9
 * O/P: 22   
 * [i.e 10+3+9]
 * 
 * Eg2) Array Elements - 7,1,2,3,6
 * O/P:19
 * 
 * Eg3) Array Elements - 1,6,4,7,9
 * O/P:10
 * 
 */
public class Arr8 {
    public static void main(String[] args) {
        int[] arr1 = {10,3,6,1,2,7,9};
        int[] arr2 = {7,1,2,3,6};
        int[] arr3 = {1,6,4,7,9};
        System.out.println(sumOfArray(arr1));
        System.out.println(sumOfArray(arr2));
        System.out.println(sumOfArray(arr3));
    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        boolean isSix = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 6) {
                isSix = true;
            } else if (arr[i] == 7) {
                isSix = false;
            } else if (!isSix) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
