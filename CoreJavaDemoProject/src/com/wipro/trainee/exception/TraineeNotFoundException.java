package com.wipro.trainee.exception;

public class TraineeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8472469758417836613L;

	int id;
	
	public TraineeNotFoundException(int id) {
		super();
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Trainee with ID" + id + " not found";
	}

	@Override
	public String toString() {
		return "Trainee with ID" + id + " not found";
	}
	
	
	
}
