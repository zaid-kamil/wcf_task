package java_fundamentals;

/*
 * Write a program to print the sum of all the digits of a given number.
 * 
 * Example1) 
 * I/P:1234
 * O/P:10
 * 
 */
public class Fcs14 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }
        int num = Integer.parseInt(args[0]);
        System.out.println(sumOfDigits(num));
    }
    
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
