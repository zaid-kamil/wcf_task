package com.java.fundamentals;


/*
 * Write a program to print * in Floyds format (using for and while loop)
* *
* *  *
* *  *   *
* 
* Example1)
* C:\>java Sample 
* O/P: Please enter an integer number
* 
* Example2)
* C:\>java Sample 3
* O/P :
*
* *
* *  * 
* *  *  *
 */

public class Fcs15 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter an integer number");
            return;
        }
        int num = Integer.parseInt(args[0]);
        printFloydsTriangle(num);
    }

    private static void printFloydsTriangle(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
