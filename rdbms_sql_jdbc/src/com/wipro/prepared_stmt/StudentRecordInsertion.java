package com.wipro.prepared_stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentRecordInsertion {
    // Database connection details
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    
    // Valid Roman numerals for Standard
    private static final List<String> VALID_STANDARDS = Arrays.asList(
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Load JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connection established successfully");
                
                boolean addMore = true;
                while(addMore) {
                    insertStudentRecord(connection, scanner);
                    
                    System.out.print("Add another student? (y/n): ");
                    addMore = scanner.next().toLowerCase().startsWith("y");
                    scanner.nextLine(); // consume newline
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    private static void insertStudentRecord(Connection connection, Scanner scanner) {
        try {
            // Get student details with validation
            int rollno = getRollNo(scanner);
            String studentName = getStudentName(scanner);
            String standard = getStandard(scanner);
            java.sql.Date dateOfBirth = getDateOfBirth(scanner);
            double fees = getFees(scanner);
            
            // Prepare SQL statement
            String sql = "INSERT INTO student (Rollno, StudentName, Standard, Date_Of_Birth, Fees) " +
                         "VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, rollno);
                pstmt.setString(2, studentName);
                pstmt.setString(3, standard);
                pstmt.setDate(4, dateOfBirth);
                pstmt.setDouble(5, fees);
                
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student record inserted successfully!");
                } else {
                    System.out.println("Failed to insert student record.");
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }
    
    // Validation methods
    private static int getRollNo(Scanner scanner) {
        int rollno = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter Roll Number (4 digits): ");
            if (scanner.hasNextInt()) {
                rollno = scanner.nextInt();
                if (rollno >= 1000 && rollno <= 9999) {
                    valid = true;
                } else {
                    System.out.println("Invalid! Roll Number must be a 4-digit number.");
                }
            } else {
                System.out.println("Invalid! Please enter a number.");
                scanner.next();
            }
        }
        scanner.nextLine(); // consume newline
        return rollno;
    }
    
    private static String getStudentName(Scanner scanner) {
        String name = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter Student Name (max 20 uppercase letters): ");
            name = scanner.nextLine().toUpperCase();
            
            if (name.matches("[A-Z ]{1,20}") && name.length() <= 20) {
                valid = true;
            } else {
                System.out.println("Invalid! Name must contain only letters and be maximum 20 characters.");
            }
        }
        return name;
    }
    
    private static String getStandard(Scanner scanner) {
        String standard = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter Standard (Roman numeral I to X): ");
            standard = scanner.nextLine().toUpperCase();
            
            if (VALID_STANDARDS.contains(standard)) {
                valid = true;
            } else {
                System.out.println("Invalid! Standard must be a Roman numeral from I to X.");
            }
        }
        return standard;
    }
    
    private static java.sql.Date getDateOfBirth(Scanner scanner) {
        java.sql.Date sqlDate = null;
        boolean valid = false;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        while (!valid) {
            System.out.print("Enter Date of Birth (dd/mm/yyyy, or press Enter to skip): ");
            String dob = scanner.nextLine();
            
            if (dob.trim().isEmpty()) {
                return null; // Date is optional
            }
            
            try {
                java.util.Date utilDate = sdf.parse(dob);
                sqlDate = new java.sql.Date(utilDate.getTime());
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please use dd/mm/yyyy.");
            }
        }
        return sqlDate;
    }
    
    private static double getFees(Scanner scanner) {
        double fees = 0.0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter Fees (or press Enter to skip): ");
            String feesStr = scanner.nextLine();
            
            if (feesStr.trim().isEmpty()) {
                return 0.0; // Fees is optional
            }
            
            try {
                fees = Double.parseDouble(feesStr);
                if (fees >= 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid! Fees cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter a valid number.");
            }
        }
        return fees;
    }
}