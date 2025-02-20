package com.wipro.hibernateapp;

import com.wipro.hibernateapp.dao.EmployeeDao;
import com.wipro.hibernateapp.entity.Employee;
import com.wipro.hibernateapp.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		/*
		 * Employee emp = new Employee(); // insert new object emp.setEmpName("Snavi");
		 * emp.setDepartment("Sales"); emp.setEmail("snavi@gmail.com");
		 * dao.addEmployee(emp);
		 * 
		 * // list employees dao.getEmployees().stream().forEach(e -> e.show());
		 * 
		 * // list employees by department
		 * dao.getEmployeeByDepartment("Sales").stream().forEach(e -> e.show());
		 */
		
		Student std = new Student();
		std.setId(5);
		std.setName("Baby");
		std.setSchool("St Mary School");
		
		dao.addStudent(std);
		dao.getStudents().stream().forEach(System.out::println);
	}
}
