package java_fundamentals;

/*
 * Write a program to receive a number and print the corresponding month name.
 * Example1)
 * 
 * C:\>java Sample 12
 * 
 * O/P Expected : December
 * 
 * Example2)
 * 
 * C:\>java Sample 
 * 
 * O/P Expected : Please enter the month in numbers
 * 
 * Example3)
 * 
 * C:\>java Sample 15
 * 
 * O/P Expected : Invalid month
 */

public class Fcs9 {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Please enter the month in numbers");
            return;
        }
        int month = Integer.parseInt(args[0]);
        switch (month) {
            case 1 -> System.out.println("January");
            case 2 -> System.out.println("February");
            case 3 -> System.out.println("March");
            case 4 -> System.out.println("April");
            case 5 -> System.out.println("May");
            case 6 -> System.out.println("June");
            case 7 -> System.out.println("July");
            case 8 -> System.out.println("August");
            case 9 -> System.out.println("September");
            case 10 -> System.out.println("October");
            case 11 -> System.out.println("November");
            case 12 -> System.out.println("December");
            default -> System.out.println("Invalid month");
        }
    }
}
