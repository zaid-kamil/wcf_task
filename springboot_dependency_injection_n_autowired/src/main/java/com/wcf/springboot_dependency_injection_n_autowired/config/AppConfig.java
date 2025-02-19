package com.wcf.springboot_dependency_injection_n_autowired.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wcf.springboot_dependency_injection_n_autowired.model.Battery;
import com.wcf.springboot_dependency_injection_n_autowired.model.HardDisk;
import com.wcf.springboot_dependency_injection_n_autowired.model.Laptop;

@Configuration
public class AppConfig{
    @Bean
    public Battery battery(){
        Battery battery = new Battery();
        battery.setCapacity(5000);
        battery.setType("Li-ion");
        return battery;
    }

    @Bean
    public HardDisk hardDisk(){
        HardDisk hardDisk = new HardDisk();
        hardDisk.setStorageSize(512);
        hardDisk.setType("SSD");
        return hardDisk;
    }

    @Bean
    public Laptop laptop(Battery battery, HardDisk hardDisk){
        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        laptop.setModel("Legion 5 Pro");
        laptop.setBattery(battery);
        laptop.setHardDisk(hardDisk);
        return laptop;
    }
}