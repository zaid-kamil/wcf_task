package com.wipro.talentnext;

public class Exam {
	boolean validateAge(int age) throws AgeValidationException {
		if (age > 21)
			return true;
		throw new AgeValidationException(age);
	}
}
