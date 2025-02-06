package java_fundamentals;
/*
 * Write a program to check if a
 * given integer number is odd or even.
 */

public class Fcs2 {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("No arguments provided");
            return;
        }
        int value = Integer.parseInt(args[0]);
        if (value % 2 == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}
