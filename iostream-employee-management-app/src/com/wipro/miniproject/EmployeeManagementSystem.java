package com.wipro.miniproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.wipro.miniproject.model.Employee;

public class EmployeeManagementSystem {

	static final String FILE_NAME = "employee.dat";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Main Menu");
			System.out.println("1. Add an Employee");
			System.out.println("2. Display All");
			System.out.println("3. Exit");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				addEmployee(scanner);
				break;
			case 2:
				displayAllEmployees();
				break;
			case 3:
				System.out.println("Exiting the System");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid Option. Please try again.");
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void addEmployee(Scanner scanner) {
		try {
			System.out.print("Enter Employee ID: ");
			int id = scanner.nextInt();
			scanner.nextLine(); 
			System.out.print("Enter Employee Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter Employee Age: ");
			int age = scanner.nextInt();
			System.out.print("Enter Employee Salary: ");
			double salary = scanner.nextDouble();
			scanner.nextLine(); 

			Employee emp = new Employee(id, name, age, salary);

			ArrayList<Employee> list = new ArrayList<>();
			File file = new File(FILE_NAME);
			if (file.exists()) {
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
					list = (ArrayList<Employee>) ois.readObject();
				} catch (Exception e) {
					System.out.println("Error reading existing employees: " + e.getMessage());
				}
			}

			// Add the new employee and serialize the updated list
			list.add(emp);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
				oos.writeObject(list);
			}
		} catch (Exception e) {
			System.out.println("Error adding employee: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private static void displayAllEmployees() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			System.out.println("No Employee record found.");
			return;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
			System.out.println("----Report-----");
			for (Employee emp : list) {
				System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getAge() + " " + emp.getSalary());
			}
			System.out.println("----End of Report-----");
		} catch (Exception e) {
			System.out.println("Error displaying employees: " + e.getMessage());
		}
	}
}
