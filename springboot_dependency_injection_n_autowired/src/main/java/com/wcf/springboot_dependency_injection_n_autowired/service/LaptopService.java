package com.wcf.springboot_dependency_injection_n_autowired.service;

import org.springframework.stereotype.Service;

import com.wcf.springboot_dependency_injection_n_autowired.model.Laptop;

@Service
public class LaptopService {
    private final Laptop laptop;
    
    public LaptopService(Laptop laptop) {
        this.laptop = laptop;
    }

    public String getLaptopDetails() {
        return "Laptop Brand: " + laptop.getBrand() + ", Model: " + laptop.getModel() + ", Battery Capacity: " + laptop.getBattery().getCapacity() + ", Hard Disk Storage: " + laptop.getHardDisk().getStorageSize();
    }
}
