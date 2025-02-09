package java_fundamentals;
/*
 * Given an array of type int, print true if every element is 1 or 4. 

 * only14([1, 4, 1, 4]) → true
 * only14([1, 4, 2, 4]) → false
 * only14([1, 1]) → true
 */
public class Arr11 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 1, 4};
        int[] arr2 = {1, 4, 2, 4};
        int[] arr3 = {1, 1};
        System.out.println(only14(arr1));
        System.out.println(only14(arr2));
        System.out.println(only14(arr3));
    }

    public static boolean only14(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
        }
        return true;
    }
}
