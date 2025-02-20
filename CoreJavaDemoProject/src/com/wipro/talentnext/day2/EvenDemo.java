package com.wipro.talentnext.day2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EvenDemo {
	public static void main(String[] args) {
		Predicate<Integer> predicate = n -> n % 2 == 0;
		System.out.println(predicate.test(210));

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> evenNums = nums.stream().filter(n -> n % 2 == 0).toList();

		System.out.println(nums);
		System.out.println(evenNums);

		double[] cubes = nums.stream().mapToDouble(n -> Math.pow(n, 3)).toArray();
		for (double d : cubes) {
			System.out.print(d+", ");
		}
	}
}
