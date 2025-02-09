package oops;

import java.util.Optional;  

/*
 * Given an Employee object which may be initialized to null, 
 * use Optional class to check if it is null and to throw an 
 * user defined exception InvalidEmployeeException.
 */

public class Opt3 {
public static void main(String[] args) {
    Employee employee = null; // This can be null or an actual Employee object

    try {
        Optional.ofNullable(employee).orElseThrow(InvalidEmployeeException::new);
        System.out.println("Employee is valid");
    } catch (InvalidEmployeeException e) {
        System.out.println("Caught exception: " + e.getMessage());
    }
}

static class Employee {
    String name;
    int age;
}

static class InvalidEmployeeException extends RuntimeException {
    public InvalidEmployeeException() {
        super("Invalid Employee");
    }
}
}
