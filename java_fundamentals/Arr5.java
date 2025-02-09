package java_fundamentals;

/*
 * Write a program to find the largest 2 numbers 
 * and the smallest 2 numbers in the given array.
 */

public class Arr5 {
    public static void main(String[] args) {
        int[] arr = {12, 12, 33, 44, 51,3 ,3 ,-12 ,22 ,13};
        int max1 = arr[0];
        int max2 = arr[0];
        int min1 = arr[0];
        int min2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }
        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);
        System.out.println("Min1: " + min1);
        System.out.println("Min2: " + min2);
    }
}
