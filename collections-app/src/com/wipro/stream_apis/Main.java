package com.wipro.stream_apis;

import java.util.ArrayList;
import java.util.List;

class Student {
    int rollNo;
    String name;
    int mark;
    
    public Student(int rollNo, String name, int mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark = mark;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create ArrayList and add five Student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 55));
        students.add(new Student(2, "Bob", 45));
        students.add(new Student(3, "Charlie", 65));
        students.add(new Student(4, "David", 49));
        students.add(new Student(5, "Eve", 75));
        
        // Filter students who have cleared the test with minimum 50 marks
        long count = students.stream()
                .filter(student -> student.mark >= 50)
                .count();
        
        // Print the count of students who have cleared
        System.out.println("Number of students who cleared the test: " + count);
    }
}