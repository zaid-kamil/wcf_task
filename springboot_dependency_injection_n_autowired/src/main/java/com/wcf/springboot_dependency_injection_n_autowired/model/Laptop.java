package com.wcf.springboot_dependency_injection_n_autowired.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private String brand;
    private String model;

    @Autowired
    private Battery battery;

    @Autowired
    private HardDisk hardDisk;


    public Laptop() {
    }

    public Laptop(String brand, String model, Battery battery) {
        this.brand = brand;
        this.model = model;
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }
}