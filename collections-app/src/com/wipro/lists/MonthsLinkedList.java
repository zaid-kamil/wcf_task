package com.wipro.lists;

import java.util.LinkedList;

public class MonthsLinkedList {
	public static void main(String[] args) {
		// Create LinkedList to store months
		LinkedList<String> months = new LinkedList<>();

		// Add all months to the LinkedList
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");

		// Print all months using enhanced for loop
		System.out.println("Months of the year using for loop:");
		for (String month : months) {
			System.out.println(month);
		}

		// Alternative way to print using forEach method
		System.out.println("\nMonths of the year using forEach:");
		months.forEach(System.out::println);

		// Demonstrating some LinkedList specific methods
		System.out.println("\nFirst month: " + months.getFirst());
		System.out.println("Last month: " + months.getLast());
	}
}