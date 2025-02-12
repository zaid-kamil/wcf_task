package com.wipro.tm04;

public class Employee implements Cloneable {
	private int empId;
	private String name;
	private double salary;
	private String department;

	public Employee(int empId, String name, double salary, String department) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	// Getters and Setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Employee ["
				+ "empId=" + empId 
				+ ", name=" + name 
				+ ", salary=" + salary 
				+ ", department=" + department
				+ "]";
	}
}