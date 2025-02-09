package java_fundamentals;

/*
 * Write a program to initialize an integer
 * array and print the sum and average of the array.
 */
public class Arr1 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 15};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / arr.length));
    }
}
