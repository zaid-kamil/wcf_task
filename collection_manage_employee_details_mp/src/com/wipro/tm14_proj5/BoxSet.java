package com.wipro.tm14_proj5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoxSet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of Boxes: ");
		int n = scanner.nextInt();

		Set<Box> boxSet = new HashSet<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Box " + (i + 1) + " details");
			System.out.print("Enter Length: ");
			double length = scanner.nextDouble();
			System.out.print("Enter Width: ");
			double width = scanner.nextDouble();
			System.out.print("Enter Height: ");
			double height = scanner.nextDouble();

			Box box = new Box(length, width, height);
			boxSet.add(box);
		}

		System.out.println("Unique Boxes in the Set are:");
		for (Box box : boxSet) {
			System.out.println(box);
		}

		scanner.close();
	}
}