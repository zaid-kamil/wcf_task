package com.wipro.tm03.exception;

@SuppressWarnings("serial")
public class InvalidCountryException extends Exception {
    // Default constructor
    public InvalidCountryException() {
        super();
    }
    
    // Parameterized constructor
    public InvalidCountryException(String message) {
        super(message);
    }
}
