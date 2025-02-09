package java_fundamentals;

/*
 * Write a program to initialize an integer array with 
 * values and check if a given number is present in the array or not.
 * 
 * If the number is not found, it will print -1 else it will print the
 * index value of the given  number in the array.
 * 
 * Example 1) If the Array elements are  {1,4,34,56,7} and the search
 * element is 90, then the output expected is -1.
 * 
 * Example 2)If the Array elements are  {1,4,34,56,7} and the
 * search element is 56, then the output expected is 3.
 * 
 */
public class Arr3 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 34, 56, 7};
        int search = 56;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
