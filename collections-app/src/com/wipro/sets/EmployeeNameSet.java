package com.wipro.sets;

import java.util.HashSet;
import java.util.Iterator;

public class EmployeeNameSet {
    private HashSet<String> employeeNames;

    public EmployeeNameSet() {
        employeeNames = new HashSet<>();
    }

    public void addEmployee(String name) {
        employeeNames.add(name);
    }

    public void displayEmployees() {
        System.out.println("Employees in the HashSet:");
        Iterator<String> iterator = employeeNames.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }

    public static void main(String[] args) {
        EmployeeNameSet employees = new EmployeeNameSet();

        // Adding employee names
        employees.addEmployee("Zaid Kamil");
        employees.addEmployee("Emma Watson");
        employees.addEmployee("Michael Johnson");
        employees.addEmployee("Sarah William");
        employees.addEmployee("David Hudson");
        
        // Try adding a duplicate name (will be ignored by HashSet)
        employees.addEmployee("John Smith");

        // Display all employees
        employees.displayEmployees();

        // Demonstrate direct iteration using Iterator
        System.out.println("\nAlternative way to iterate:");
        Iterator<String> iter = employees.employeeNames.iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            System.out.println("Employee: " + name);
        }
    }
}