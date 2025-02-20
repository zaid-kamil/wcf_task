package com.wipro.employee.service;

import java.util.Scanner;

import com.wipro.employee.beans.EmployeeBean;
import com.wipro.employee.dao.EmployeeDao;

public class EmployeeService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();
		do {
			System.out.println("══════════════════════════════");
			System.out.println("🏢 Employee Management Service");
			System.out.println("══════════════════════════════");
			System.out.println("🪟 ► View ▫ 1");
			System.out.println("📦 ► Add ▫ 2");
			System.out.println("🚮 ► Delete ▫ 3");
			System.out.println("🔌 ► Exit ▫ 4");
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
				System.out.println("App closed");
				sc.close();
				System.exit(0);
			}
		} while (true);

	}

	private static void deleteEmployee(EmployeeDao dao, Scanner sc) {
		System.out.println("🔑 Enter Id of employee");
		int id = Integer.parseInt(takeInput(sc, "ID:"));
		long result = dao.deleteEmpById(id);
		if (result != -1) {
			System.out.println("🎉 Employee Record ☠️ successfully 🎉");
		} else if (result == 0) {
			System.out.println("🫗 No Record Found 🫗");
		} else {
			System.err.println("☠️ Failed to Delete Employee ☠️");
		}
	}

	private static void addNewEmployee(EmployeeDao dao, Scanner sc) {
		System.out.println("Enter employee details");
		String name = takeInput(sc, "Enter Name");
		String email = takeInput(sc, "Enter email");
		String dept = takeInput(sc, "Enter dept");
		dao.addEmployee(new EmployeeBean(name, email, dept));
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