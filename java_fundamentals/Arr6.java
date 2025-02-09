package java_fundamentals;

/*
 * Write a program to initialize an array and print them in a sorted order.
 */
public class Arr6 {
    public static void main(String[] args) {
        int[] arr = {12, 12, 33, 44, 51,3 ,3 ,-12 ,22 ,13};
        // Bubble sort
        for (int i = 0; i < arr.length; i++) {
            // i = 0, j = 1
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
