package com.wipro.participant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String BATCH_NUM = "202421";
	private static final String PBLAPP_ID = "2421030";
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String SQLITE_URL = "jdbc:sqlite:cms01.sqlite3";
	public static final String USERNAME = "B" + BATCH_NUM + PBLAPP_ID;
	public static final String PASSWORD = "B" + BATCH_NUM + PBLAPP_ID;

	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

	public static Connection getDBConnection() {
		Connection con = null;
		// try {
		// Class.forName(ORACLE_DRIVER);
		// System.out.println("Driver loaded successfully.");
		// } catch (ClassNotFoundException e) {
		// System.err.println("JDBC Driver not found! Please check the classpath.");
		// return null; // Stop further execution if the driver is missing
		// }
		try {
			con = DriverManager.getConnection(ORCL_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.err.println("Error in getting connection: " + e.getMessage());
		}
		return con;
	}

}
