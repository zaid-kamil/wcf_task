package java_fundamentals;
/*
 * Write a program to reverse a given number and print
 * 
 * Example1)
 * I/P: 1234
 * O/P:4321
 * 
 * Example2)
 * I/P:1004
 * O/P:4001
 * 
 */
public class Fcs16 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }
        int num = Integer.parseInt(args[0]);
        System.out.println(reverseNumber(num));
    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
