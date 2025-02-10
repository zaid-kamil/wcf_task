package com.miniprojects.TM01_proj1;

class Employee {

    final int empNo;
    final String empName;
    final String joinDate;
    final char designationCode;
    final String department;
    final double basic;
    final double hra;
    final double it;

    public Employee(int empNo, String empName, String joinDate, char designationCode,
            String department, double basic, double hra, double it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.designationCode = designationCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
    public double calculateSalary(double da) {
        return basic + hra + da - it;
    }
}

public class Project_1 {

    static Employee[] getEmployeesData(){
        Employee[] employees = {
            new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman", "1/1/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
        };
        return employees;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide employee ID");
            return;
        }

        Employee[] employees = getEmployeesData();

        int searchId = Integer.parseInt(args[0]);
        
        Employee found = null;
        for (Employee emp : employees) {
            if (emp.empNo == searchId) {
                found = emp;
                break;
            }
        }

        if (found == null) {
            System.out.println("There is no employee with empid : " + searchId);
            return;
        }

        double da = getDa(found.designationCode);
        String designation = getDesignation(found.designationCode);

        System.out.printf("Emp No.  Emp Name    Department    Designation    Salary%n");
        System.out.printf("%-9d %-11s %-13s %-13s %.0f%n",
                found.empNo,
                found.empName,
                found.department,
                designation,
                found.calculateSalary(da));
    }

    private static double getDa(char code) {
        return switch (code) {
            case 'e' -> 20000;
            case 'c' -> 32000;
            case 'k' -> 12000;
            case 'r' -> 15000;
            case 'm' -> 40000;
            default -> 0;
        };
    }

    private static String getDesignation(char code) {
        return switch (code) {
            case 'e' -> "Engineer";
            case 'c' -> "Consultant";
            case 'k' -> "Clerk";
            case 'r' -> "Receptionist";
            case 'm' -> "Manager";
            default -> "Unknown";
        };
    }
}
