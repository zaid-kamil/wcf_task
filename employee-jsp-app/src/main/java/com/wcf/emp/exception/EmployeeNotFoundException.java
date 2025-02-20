package com.wcf.emp.exception;

public class EmployeeNotFoundException extends Exception {
	@Override
	public String toString() {
		return "Employee Not Found";
	}
}
