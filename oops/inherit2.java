package oops;

/*
 * Create a class called Person with a member variable name. Save it in a file called Person.java

 * Create a class called Employee that will inherit the Person class.The other data members of the 
 * Employee class are annual salary (double), the year the employee started to work, and the 
 * national insurance number which is a String.Save this in a file called Employee.java
 * 
 * Your class should have the necessary constructors and getter/setter methods.
 * 
 * Write another class called TestEmployee, containing a main method to fully test your class definition.
 */

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Employee extends Person {
    private final double annualSalary;
    private final int yearStarted;
    private final String nationalInsuranceNumber;

    public Employee(String name, double annualSalary, int yearStarted, String nationalInsuranceNumber) {
        super(name);
        this.annualSalary = annualSalary;
        this.yearStarted = yearStarted;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

}


public class Inherit2 {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 100000, 2020, "1234567890");
        System.out.println("Name: " + employee.getName());
        System.out.println("Annual Salary: " + employee.getAnnualSalary());
        System.out.println("Year Started: " + employee.getYearStarted());
        System.out.println("National Insurance Number: " + employee.getNationalInsuranceNumber());
    }
}

