package com.wipro.tm14_proj1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeRegister {
	public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
				List<Employee> employees = new ArrayList<Employee>();
				boolean exit = false;

				while (!exit) {
				    System.out.println("\nMenu:");
				    System.out.println("1. Add Employee");
				    System.out.println("2. Display Employees");
				    System.out.println("3. Exit");
				    System.out.print("Enter your choice: ");
				    int choice = scanner.nextInt();
				    scanner.nextLine(); // Consume newline

				    switch (choice) {
				        case 1:
				            System.out.println("Enter Employee Details:");
				            System.out.print("Enter the Firstname: ");
				            String firstName = scanner.nextLine();
				            System.out.print("Enter the Lastname: ");
				            String lastName = scanner.nextLine();
				            System.out.print("Enter the Mobile: ");
				            String mobile = scanner.nextLine();
				            System.out.print("Enter the Email: ");
				            String email = scanner.nextLine();
				            System.out.print("Enter the Address: ");
				            String address = scanner.nextLine();

				            employees.add(new Employee(firstName, lastName, mobile, email, address));
				            break;
				        case 2:
				            Collections.sort(employees, Comparator.comparing(e -> e.firstName));	
				            System.out.format("%-15s %-15s %-15s %-30s %-15s\n", "Firstname", "Lastname", "Mobile", "Email", "Address");
				            for (Employee employee : employees) {
				                System.out.println(employee);
				            }
				            break;
				        case 3:
				            exit = true;
				            break;
				        default:
				            System.out.println("Invalid choice. Please try again.");
				    }
				}
			}
	    }
}
