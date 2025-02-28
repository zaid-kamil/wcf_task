package com.wipro.establishing_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {
    public static void main(String[] args) {
        // JDBC URL, username, and password of Oracle database
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "username";
        String password = "password";
        
        Connection connection = null;
        
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // Display success message
            System.out.println("Connection Established successfully");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Connection could not be established");
            System.out.println("Description of the exception: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection could not be established");
            System.out.println("Description of the exception: " + e.getMessage());
        } finally {
            // Close the connection when done
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}