package com.wipro.functional_interfaces;

import java.util.ArrayList;
import java.util.function.Supplier;

public class PrimeNumberSupplier {
    public static void main(String[] args) {
        Supplier<ArrayList<Integer>> primeSupplier = () -> {
            ArrayList<Integer> primes = new ArrayList<>();
            int count = 0;
            int number = 2;
            while (count < 10) {
                if (isPrime(number)) {
                    primes.add(number);
                    count++;
                }
                number++;
            }
            return primes;
        };
        ArrayList<Integer> primeNumbers = primeSupplier.get();
        System.out.println(primeNumbers);
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
			return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
			if (number % i != 0)
				return false;
        return true;
    }
}
