package com.wipro.datetime_api;

import java.time.Year;
import java.util.Scanner;

public class LeapYearChecker {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter year:");
			String year = sc.nextLine();
			if (year.isEmpty() || !year.matches(".*\\d.*")) {
				System.err.println("Year required");
			} else {
				Year currentYear = Year.parse(year);
				if (currentYear.isLeap()) {
					System.out.println(currentYear.getValue() + " is a leap year.");
				} else {
					System.out.println(currentYear.getValue() + " is not a leap year.");
				}
			}
		}
	}
}