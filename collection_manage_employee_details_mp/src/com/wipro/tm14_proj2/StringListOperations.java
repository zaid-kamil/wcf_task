package com.wipro.tm14_proj2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringListOperations {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> items = new ArrayList<>();
			boolean exit = false;

			while (!exit) {
				System.out.println("\nMenu:");
				System.out.println("1. Insert");
				System.out.println("2. Search");
				System.out.println("3. Delete");
				System.out.println("4. Display");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (choice) {
				case 1:
					System.out.print("Enter the item to be inserted: ");
					String itemToInsert = scanner.nextLine();
					items.add(itemToInsert);
					System.out.println("Inserted successfully");
					break;
				case 2:
					System.out.print("Enter the item to search: ");
					String itemToSearch = scanner.nextLine();
					if (items.contains(itemToSearch)) {
						System.out.println("Item found in the list.");
					} else {
						System.out.println("Item not found in the list.");
					}
					break;
				case 3:
					System.out.print("Enter the item to delete: ");
					String itemToDelete = scanner.nextLine();
					if (items.remove(itemToDelete)) {
						System.out.println("Deleted successfully");
					} else {
						System.out.println("Item does not exist.");
					}
					break;
				case 4:
					System.out.println("The Items in the list are:");
					for (String item : items) {
						System.out.println(item);
					}
					break;
				case 5:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
		}

	}
}