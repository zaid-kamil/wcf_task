package java_fundamentals;

/*
 * Write a program to remove the duplicate 
 * elements in an array and print the same.
 * Example:
 * I/P:{12,34,12,45,67,89}
 * O/P:{12,34,45,67,89}
 */

public class Arr7 {
    public static void main(String[] args) {
        int[] arr = {12,34,12,45,67,89};
        int[] newArr = removeDuplicates(arr);
        printArray(newArr);
    }

    public static int[] removeDuplicates(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int k = 0; k < j; k++) {
                if (arr[i] == newArr[k]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArr[j] = arr[i];
                j++;
            }
        }
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = newArr[i];
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
