package com.automobile.fourwheeler;

import com.automobile.Vehicle;

public class Logan extends Vehicle {
    private String modelName;
    private String registrationNumber;
    private String ownerName;
    private int currentSpeed;

    public Logan(String modelName, String registrationNumber, String ownerName) {
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.currentSpeed = 0;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    public int speed() {
        return currentSpeed;
    }

    public int gps() {
        System.out.println("Controlling GPS device in Logan");
        return 1; // Return 1 to indicate GPS is working
    }
}