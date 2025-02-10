package com.mile1.main;

import com.mile1.bean.Student;
import com.mile1.exception.*;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentMain {
	static Student[] data = new Student[4];

	public StudentMain() {
		// Initializing students
		data[0] = new Student("John", new int[] { 85, 90, 80 });
		data[1] = new Student("Jane", new int[] { 30, 25, 40 }); // Should fail due to low marks
		data[2] = new Student(null, new int[] { 75, 80, 70 }); // Null name exception
		data[3] = null; // Null student object exception
	}

	public static void main(String[] args) {
		StudentMain sm = new StudentMain();
		StudentReport sr = new StudentReport();
		StudentService ss = new StudentService();

		for (Student student : data) {
			try {
				String validation = sr.validate(student);
				if ("VALID".equals(validation)) {
					String grade = sr.findGrades(student);
					student.setGrade(grade);
					System.out.println("Student: " + student.getName() + " | Grade: " + grade);
				}
			} catch (NullStudentObjectException e) {
				System.out.println(e);
			} catch (NullNameException e) {
				System.out.println(e);
			} catch (NullMarksArrayException e) {
				System.out.println(e);
			}
		}

		System.out.println("\nSummary:");
		System.out.println("Number of Students with null names: " + ss.findNumberOfNullName(data));
		System.out.println("Number of Students with null marks array: " + ss.findNumberOfNullMarksArray(data));
		System.out.println("Number of null Student objects: " + ss.findNumberOfNullObjects(data));
	}
}
