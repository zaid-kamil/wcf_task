package com.wipro.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String BATCH_NUM = "202421";
	private static final String PBLAPP_ID = "2421030";
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "B" + BATCH_NUM + PBLAPP_ID;
	public static final String PASSWORD = "B" + BATCH_NUM + PBLAPP_ID;
	private static Connection connection = null;
	private static final String SQLITE_URL = "jdbc:sqlite:bdb.sqlite3";

	public static Connection getDBConnection() throws SQLException {
		connection = DriverManager.getConnection(ORCL_URL, USERNAME, PASSWORD);
		return connection;
	}
}
