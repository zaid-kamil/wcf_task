package com.wipro.employee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public final static String DB_USER = "scott";
	public final static String DB_PWD = "Wipro123";
	public final static String EMPLOYEE_TBL = "employee";
	public final static String EMP_COL_ID = "id";
	public final static String EMP_COL_NAME = "name";	
	public final static String EMP_COL_EMAIL = "email";
	public final static String EMP_COL_DEPT = "dept";
	
	public static Connection getConnection() {
		
		checkDriver("oracle.jdbc.driver.OracleDriver");
		try {
			return DriverManager.getConnection(URL, DB_USER, DB_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
