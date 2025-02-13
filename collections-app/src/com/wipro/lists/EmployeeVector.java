package com.wipro.lists;

import java.util.Vector;

import com.wipro.lists.model.Employee;

import java.util.Iterator;
import java.util.Enumeration;

public class EmployeeVector {

    public static void main(String[] args) {
        // Create Vector of Employee objects
        Vector<Employee> employees = new Vector<>();

        // Add sample employees
        employees.add(new Employee(1001, "John Doe", "john@example.com", "Male", 50000.0f));
        employees.add(new Employee(1002, "Jane Smith", "jane@example.com", "Female", 55000.0f));
        employees.add(new Employee(1003, "Bob Wilson", "bob@example.com", "Male", 45000.0f));

        // Using Iterator
        System.out.println("Displaying employees using Iterator:");
        System.out.println("===================================");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            emp.GetEmployeeDetails();
            System.out.println();
        }

        // Using Enumeration
        System.out.println("Displaying employees using Enumeration:");
        System.out.println("=====================================");
        Enumeration<Employee> enumeration = employees.elements();
        while (enumeration.hasMoreElements()) {
            Employee emp = enumeration.nextElement();
            emp.GetEmployeeDetails();
            System.out.println();
        }

        // Display Vector information
        System.out.println("Vector Size: " + employees.size());
        System.out.println("Vector Capacity: " + employees.capacity());
    }
}
