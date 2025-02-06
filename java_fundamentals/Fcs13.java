package java_fundamentals;

/*
 * Write a program to print prime numbers between 10 and 99.
 */

public class Fcs13 {
    public static void main(String[] args) {
        for (int i = 11; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
