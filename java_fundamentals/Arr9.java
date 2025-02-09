package java_fundamentals;
/*
 * Print a version of the given array where all the 10's have been removed. 
 * 
 * The remaining elements should shift left towards the start of the array 
 * as needed, and the empty spaces at the end of the array should be 0. 
 * So {1, 10, 10, 2} yields {1, 2, 0, 0}. 
 * 
 * You may modify and display the given array or make a new array.
 * withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
 * withoutTen([10, 2, 10]) → [2, 0, 0]
 * withoutTen([1, 99, 10]) → [1, 99, 0]
 */

public class Arr9 {
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 10, 2};
        int[] arr2 = {10, 2, 10};
        int[] arr3 = {1, 99, 10};
        printArray(withoutTen(arr1));
        printArray(withoutTen(arr2));
        printArray(withoutTen(arr3));
    }

    public static int[] withoutTen(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 10) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
