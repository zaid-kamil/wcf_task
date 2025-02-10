package com.automobile.twowheeler;

import com.automobile.Vehicle;

public class Honda extends Vehicle {
    private final String modelName;
    private final String registrationNumber;
    private final String ownerName;
    private final int currentSpeed;

    public Honda(String modelName, String registrationNumber, String ownerName) {
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

    public int getSpeed() {
        return currentSpeed;
    }

    public void cdplayer() {
        System.out.println("Controlling Honda CD player");
    }
}