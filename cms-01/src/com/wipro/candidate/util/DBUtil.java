package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String BATCH_NUM = "202421";
	private static final String PBLAPP_ID = "2421030";
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "B" + BATCH_NUM + PBLAPP_ID;
	public static final String PASSWORD = "B" + BATCH_NUM + PBLAPP_ID;

	public static Connection getDBConn() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(ORCL_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.err.println("Error in getting connection: " + e.getMessage());
		}
		return con;
	}
}
