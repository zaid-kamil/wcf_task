package com.wcf.springboot_dependency_injection_n_autowired.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcf.springboot_dependency_injection_n_autowired.service.LaptopService;


@RestController
public class AppController {
    private LaptopService laptopService = null;

    public AppController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/")
    public String index() {
        return laptopService.getLaptopDetails();
    }
    
}
