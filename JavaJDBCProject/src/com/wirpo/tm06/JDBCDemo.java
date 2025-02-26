package com.wirpo.tm06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wirpo.tm06.model.Employee;

public class JDBCDemo {
	public static void main(String[] args) {

		// configuration variables
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "scott";
		String pwd = "Wipro123";
		// program starts here
		checkDriver("oracle.jdbc.driver.OracleDriver");
		try (Connection con = DriverManager.getConnection(url, username, pwd)) {
			System.out.println("🎉 You are connected");
			try (Statement st = con.createStatement()) {
				String query = "SELECT * FROM employee ORDER BY dept";
				try (ResultSet rs = st.executeQuery(query)) {
					List<Employee> employees = parseFromDB(rs);
					displayEmployees(employees);
				} catch (SQLException e) {
					System.out.println("⚠️⚠️⚠️ " + e.getMessage());
				}
			} catch (SQLException e) {
				System.out.println("⚠️⚠️ " + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("⚠️ " + e.getMessage());
		}

	}

	public static List<Employee> parseFromDB(ResultSet rs) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		while (rs.next()) {
			employees.add(new Employee(
				rs.getInt("id"), 
				rs.getString("name"), 
				rs.getString("email"),
				rs.getString("dept")
			));
		}
		return employees;
	}

	private static void displayEmployees(List<Employee> employees) {
		if(employees.isEmpty()) {
			System.err.println("⚠️☠️ No Employees Found ⚠️☠️");
			return;
		}
		System.out.println("➡️ Total Employees "+employees.size());
		for (Employee employee : employees) {
			employee.show();
		}

	}

	public static void checkDriver(String driverString) {
		try {
			Class.forName(driverString);
			System.out.println("🎉 Driver found successfully");
		} catch (ClassNotFoundException e) {
			System.err.println("☠️ You are a dummy");
		}
	}
}
