package com.wipro.lists;

import com.wipro.lists.data.EmployeeDB;
import com.wipro.lists.model.Employee;

public class EmployeeMain {
    public static void main(String[] args) {
        // Create EmployeeDB instance
        EmployeeDB empDB = new EmployeeDB();

        // Create and add employees
        Employee emp1 = new Employee(1001, "John Doe", "john@example.com", "Male", 50000.0f);
        Employee emp2 = new Employee(1002, "Jane Smith", "jane@example.com", "Female", 55000.0f);

        // Add employees to database
        empDB.addEmployee(emp1);
        empDB.addEmployee(emp2);

        // Test GetEmployeeDetails
        System.out.println("Employee Details:");
        emp1.GetEmployeeDetails();
        System.out.println();

        // Test showPaySlip
        System.out.println(empDB.showPaySlip(1001));
        
        // Test deleteEmployee
        System.out.println("Deleting employee 1002: " + empDB.deleteEmployee(1002));
        
        // Try to show payslip of deleted employee
        System.out.println(empDB.showPaySlip(1002));
    }
}