package com.abeh.exchan;

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
