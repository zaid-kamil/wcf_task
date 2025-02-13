package com.wipro.tm06.object_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class EmployeeSerialization {

    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee("John Doe", new Date(), "IT", "Developer", 75000.0);

        // Serialize the Employee object to a file called "data"
        try (FileOutputStream fos = new FileOutputStream("data"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(emp);
            System.out.println("Employee object has been serialized.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the Employee object from the file "data"
        try (FileInputStream fis = new FileInputStream("data"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee deserializedEmp = (Employee) ois.readObject();
            System.out.println("Employee object has been deserialized.");
            System.out.println("Name: " + deserializedEmp.getName());
            System.out.println("Date of Birth: " + deserializedEmp.getDateOfBirth());
            System.out.println("Department: " + deserializedEmp.getDepartment());
            System.out.println("Designation: " + deserializedEmp.getDesignation());
            System.out.println("Salary: " + deserializedEmp.getSalary());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}
