package com.abeh.exchan;

public class UserRegistration {
    
    public void registerUser(String username, String userCountry) throws InvalidCountryException {
        if (!userCountry.equals("India")) {
            throw new InvalidCountryException("User Outside India cannot be registered");
        }
        System.out.println("User registration done successfully");
    }
    
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        
        try {
            // Test Case 1
            System.out.println("Test Case 1:");
            registration.registerUser("Mickey", "US");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            // Test Case 2
            System.out.println("\nTest Case 2:");
            registration.registerUser("Mini", "India");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}
