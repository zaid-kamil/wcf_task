package com.wipro.prepared_stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyStudentFee {
    // Database connection details
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ModifyStudentFee <RollNumber> <NewFeeAmount>");
            System.exit(1);
        }
        
        int rollNo;
        double newFee;
        
        try {
            rollNo = Integer.parseInt(args[0]);
            if (rollNo < 1000 || rollNo > 9999) {
                System.out.println("Invalid Roll Number. Must be a 4-digit number.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Roll Number format. Please provide a valid number.");
            System.exit(1);
            return;
        }
        
        try {
            newFee = Double.parseDouble(args[1]);
            if (newFee < 0) {
                System.out.println("Invalid Fee Amount. Must be non-negative.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Fee format. Please provide a valid number.");
            System.exit(1);
            return;
        }
        
        try {
            // Load JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connection established successfully");
                
                // First check if student exists
                String checkSql = "SELECT Rollno, StudentName, Fees FROM student WHERE Rollno = ?";
                try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, rollNo);
                    
                    try (ResultSet rs = checkStmt.executeQuery()) {
                        if (rs.next()) {
                            String studentName = rs.getString("StudentName");
                            double currentFee = rs.getDouble("Fees");
                            
                            // Update the fee
                            String updateSql = "UPDATE student SET Fees = ? WHERE Rollno = ?";
                            try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                                updateStmt.setDouble(1, newFee);
                                updateStmt.setInt(2, rollNo);
                                
                                int rowsAffected = updateStmt.executeUpdate();
                                if (rowsAffected > 0) {
                                    System.out.println("Fee updated successfully for student: " + studentName);
                                    System.out.println("Roll No: " + rollNo);
                                    System.out.println("Previous Fee: " + currentFee);
                                    System.out.println("New Fee: " + newFee);
                                } else {
                                    System.out.println("Failed to update fee for student with Roll No: " + rollNo);
                                }
                            }
                        } else {
                            System.out.println("Student with Roll No " + rollNo + " not found.");
                        }
                    }
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}