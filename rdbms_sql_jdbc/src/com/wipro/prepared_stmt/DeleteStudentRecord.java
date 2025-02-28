package src.com.wipro.prepared_stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DeleteStudentRecord {
    // Database connection details
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the Roll Number as a command line argument");
            System.exit(1);
        }
        
        int rollNo;
        try {
            rollNo = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Roll Number format. Please provide a valid number");
            System.exit(1);
            return;
        }
        
        try {
            // Load JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connection established successfully");
                
                // Ensure StudentLog table exists
                createStudentLogTableIfNotExists(connection);
                
                // Begin transaction
                connection.setAutoCommit(false);
                
                try {
                    // Get student details before deletion
                    String selectSql = "SELECT Rollno, StudentName, Standard FROM student WHERE Rollno = ?";
                    try (PreparedStatement selectStmt = connection.prepareStatement(selectSql)) {
                        selectStmt.setInt(1, rollNo);
                        
                        try (ResultSet rs = selectStmt.executeQuery()) {
                            if (rs.next()) {
                                int studentRollNo = rs.getInt("Rollno");
                                String studentName = rs.getString("StudentName");
                                String standard = rs.getString("Standard");
                                
                                // Insert student details into StudentLog table
                                String insertLogSql = "INSERT INTO StudentLog (Rollno, StudentName, Standard, Leaving_date) " +
                                                     "VALUES (?, ?, ?, SYSDATE)";
                                try (PreparedStatement insertLogStmt = connection.prepareStatement(insertLogSql)) {
                                    insertLogStmt.setInt(1, studentRollNo);
                                    insertLogStmt.setString(2, studentName);
                                    insertLogStmt.setString(3, standard);
                                    
                                    int logRowsAffected = insertLogStmt.executeUpdate();
                                    if (logRowsAffected > 0) {
                                        System.out.println("Student details logged successfully in StudentLog table");
                                    } else {
                                        throw new SQLException("Failed to log student details");
                                    }
                                }
                                
                                // Delete student record from student table
                                String deleteSql = "DELETE FROM student WHERE Rollno = ?";
                                try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                                    deleteStmt.setInt(1, rollNo);
                                    
                                    int deleteRowsAffected = deleteStmt.executeUpdate();
                                    if (deleteRowsAffected > 0) {
                                        System.out.println("Student record deleted successfully");
                                    } else {
                                        throw new SQLException("Failed to delete student record");
                                    }
                                }
                                
                                // Commit transaction
                                connection.commit();
                            } else {
                                System.out.println("Student with Roll Number " + rollNo + " not found");
                            }
                        }
                    }
                } catch (SQLException e) {
                    // Rollback transaction in case of error
                    connection.rollback();
                    throw e;
                } finally {
                    // Reset auto-commit
                    connection.setAutoCommit(true);
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    private static void createStudentLogTableIfNotExists(Connection connection) throws SQLException {
        // Check if StudentLog table exists
        boolean tableExists = false;
        try (ResultSet tables = connection.getMetaData().getTables(null, null, "STUDENTLOG", null)) {
            tableExists = tables.next();
        }
        
        // Create StudentLog table if it doesn't exist
        if (!tableExists) {
            String createTableSql = "CREATE TABLE StudentLog (" +
                                   "Rollno NUMBER(4), " +
                                   "StudentName VARCHAR(20), " +
                                   "Standard VARCHAR(2), " +
                                   "Leaving_date DATE)";
            
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(createTableSql);
                System.out.println("StudentLog table created successfully");
            }
        }
    }
}

