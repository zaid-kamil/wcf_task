package com.wipro.prepared_stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DisplayStudentDetails {
    // Database connection details
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        try {
            // Load JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connection established successfully");
                
                if (args.length == 0) {
                    // No roll number provided, display all students
                    displayAllStudents(connection);
                } else {
                    // Roll number provided, display specific student
                    try {
                        int rollNo = Integer.parseInt(args[0]);
                        displayStudentByRollNo(connection, rollNo);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Roll Number format. Please provide a valid number.");
                    }
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    private static void displayAllStudents(Connection connection) throws SQLException {
        String sql = "SELECT Rollno, StudentName, Standard, Date_Of_Birth, Fees FROM student ORDER BY Rollno";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            displayStudentHeader();
            boolean foundRecords = false;
            
            while (rs.next()) {
                foundRecords = true;
                displayStudentRecord(rs);
            }
            
            if (!foundRecords) {
                System.out.println("No student records found in the database.");
            }
        }
    }
    
    private static void displayStudentByRollNo(Connection connection, int rollNo) throws SQLException {
        String sql = "SELECT Rollno, StudentName, Standard, Date_Of_Birth, Fees FROM student WHERE Rollno = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, rollNo);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                displayStudentHeader();
                
                if (rs.next()) {
                    displayStudentRecord(rs);
                } else {
                    System.out.println("No student found with Roll No: " + rollNo);
                }
            }
        }
    }
    
    private static void displayStudentHeader() {
        System.out.println("+--------+----------------------+----------+----------------+---------------+");
        System.out.println("| Roll No|     Student Name     | Standard |  Date of Birth |     Fees      |");
        System.out.println("+--------+----------------------+----------+----------------+---------------+");
    }
    
    private static void displayStudentRecord(ResultSet rs) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        int rollNo = rs.getInt("Rollno");
        String name = rs.getString("StudentName");
        String standard = rs.getString("Standard");
        
        // Handle potential null values
        java.sql.Date dob = rs.getDate("Date_Of_Birth");
        String dobStr = (dob != null) ? dateFormat.format(dob) : "N/A";
        
        double fees = rs.getDouble("Fees");
        String feesStr = (rs.wasNull()) ? "N/A" : String.format("%.2f", fees);
        
        // Format and print the student record
        System.out.printf("| %6d | %-20s | %-8s | %-14s | %13s |\n",
                rollNo, name, standard, dobStr, feesStr);
        System.out.println("+--------+----------------------+----------+----------------+---------------+");
    }
}