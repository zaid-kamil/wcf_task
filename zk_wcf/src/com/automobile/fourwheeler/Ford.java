package com.automobile.fourwheeler;

import com.automobile.Vehicle;

public class Ford extends Vehicle {
    private String modelName;
    private String registrationNumber;
    private String ownerName;
    private int currentSpeed;

    public Ford(String modelName, String registrationNumber, String ownerName) {
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

    public int tempControl() {
        System.out.println("Controlling AC temperature in Ford");
        return 1; // Return 1 to indicate temp control is working
    }
}
