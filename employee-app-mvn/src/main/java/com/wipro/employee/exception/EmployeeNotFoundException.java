package com.wipro.employee.exception;

public class EmployeeNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	public EmployeeNotFoundException(int id) {
		super("Employee Not Found with "+id+"⚠️");
	}
	
}
