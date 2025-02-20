package com.wipro.employee;

import java.sql.SQLException;
import java.util.Scanner;

import com.wipro.employee.beans.EmployeeBean;
import com.wipro.employee.dao.EmployeeDao;
import com.wipro.employee.exception.EmployeeNotFoundException;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();
		do {
			System.out.println("══════════════════════════════");
			System.out.println("🏢 Employee Management Service");
			System.out.println("══════════════════════════════");
			System.out.println("🪟 ► View    ▫ 1");
			System.out.println("📦 ► Add     ▫ 2");
			System.out.println("🚮 ► Delete  ▫ 3");
			System.out.println("🔍 ► Search  ▫ 4");
			System.out.println("🔌 ► Exit    ▫ 5");
			int choice = Integer.parseInt(takeInput(sc, "🔢→"));
			System.out.println("══════════════════════════════");
			switch (choice) {
			case 1:
				viewEmployees(dao);
				break;
			case 2:
				addNewEmployee(dao, sc);
				break;
			case 3:
				deleteEmployee(dao, sc);
				break;
			case 4:
				searchEmployee(dao, sc);
				break;
			case 5:
				System.out.println("App closed");
				sc.close();
				System.exit(0);
			}
		} while (true);

	}

	private static void searchEmployee(EmployeeDao dao, Scanner sc) {
		System.out.println("🔑 Enter Id of employee");
		int id = Integer.parseInt(takeInput(sc, "ID:"));

		try {
			EmployeeBean emp = dao.searchEmployeeByID(id);
			emp.show();
		} catch (EmployeeNotFoundException | SQLException e) {
			System.err.println("⚠️⚠️ " + e.getMessage());
		}

	}

	private static void deleteEmployee(EmployeeDao dao, Scanner sc) {
		System.out.println("🔑 Enter Id of employee");
		int id = Integer.parseInt(takeInput(sc, "ID:"));
		long result;
		try {
			result = dao.deleteEmpById(id);
			if (result != -1) {
				System.out.println("🎉 Employee Record ☠️ successfully 🎉");
			} else if (result == 0) {
				System.out.println("🫗 No Record Found 🫗");
			} else {
				System.err.println("☠️ Failed to Delete Employee ☠️");
			}
		} catch (SQLException e) {
			System.out.println("⚠️⚠️ " + e.getMessage());
		}

	}

	private static void addNewEmployee(EmployeeDao dao, Scanner sc) {
		System.out.println("Enter employee details");
		String name = takeInput(sc, "Enter Name");
		String email = takeInput(sc, "Enter email");
		String dept = takeInput(sc, "Enter dept");
		try {
			dao.addEmployee(new EmployeeBean(name, email, dept));
		} catch (SQLException e) {
			System.err.println("⚠️⚠️ " + e.getMessage());
		}
	}

	public static String takeInput(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	private static void viewEmployees(EmployeeDao dao) {
		try {
			for (EmployeeBean emp : dao.findAllEmployee()) {
				emp.show();
			}
		} catch (Exception e) {
			System.err.println("⚠️⚠️" + e.getMessage());
		}
	}
}
