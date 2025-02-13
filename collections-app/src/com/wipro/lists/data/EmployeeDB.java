package com.wipro.lists.data;

import java.util.ArrayList;

import com.wipro.lists.model.Employee;

public class EmployeeDB {
    private ArrayList<Employee> list;

    public EmployeeDB() {
        list = new ArrayList<>();
    }

    public boolean addEmployee(Employee e) {
        return list.add(e);
    }

    public boolean deleteEmployee(int empId) {
        return list.removeIf(emp -> emp.getEmpId() == empId);
    }

    public String showPaySlip(int empId) {
        for (Employee emp : list) {
            if (emp.getEmpId() == empId) {
                return String.format("""
                    PAY SLIP
                    =========
                    Employee ID: %d
                    Employee Name: %s
                    Salary: $%.2f
                    """, emp.getEmpId(), emp.getEmpName(), emp.getSalary());
            }
        }
        return "Employee not found";
    }
}