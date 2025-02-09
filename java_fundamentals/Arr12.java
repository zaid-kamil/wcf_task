package java_fundamentals;

/*
 * Given 2 int arrays, a and b, each length 3, form a 
 * new array of length 2, containing their middle elements.

 * middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
 * middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
 * middleWay([5, 2, 9, 4, 4], [1, 4, 5]) → [9, 4]
 * middleWay([1, 2, 3], [4, 1, 5, 3, 1]) → [2, 5]
 */

public class Arr12 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] arr3 = {7, 7, 7};
        int[] arr4 = {3, 8, 0};
        int[] arr5 = {5, 2, 9, 4, 4};
        int[] arr6 = {1, 4, 1, 2, 5};
        int[] arr7 = {1, 2, 3};
        int[] arr8 = {4, 1, 5, 3, 1};
        printArray(middleWay(arr1, arr2));
        printArray(middleWay(arr3, arr4));
        printArray(middleWay(arr5, arr6));
        printArray(middleWay(arr7, arr8));
    }

    public static int[] middleWay(int[] a, int[] b) {
        int[] newArr = new int[2];
        newArr[0] = a[a.length / 2];
        newArr[1] = b[b.length / 2];
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
