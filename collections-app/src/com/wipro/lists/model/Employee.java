package com.wipro.lists.model;

public class Employee {
    private int empId;
    private String empName;
    private String email;
    private String gender;
    private float salary;

    // Constructor
    public Employee(int empId, String empName, String email, String gender, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    // Getters and setters
    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public float getSalary() { return salary; }

    // Method to print employee details
    public void GetEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: $" + salary);
    }
}