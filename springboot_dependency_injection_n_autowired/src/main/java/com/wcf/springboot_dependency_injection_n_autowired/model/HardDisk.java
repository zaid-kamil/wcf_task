package com.wcf.springboot_dependency_injection_n_autowired.model;

import org.springframework.stereotype.Component;

@Component
public class HardDisk {
    private int storageSize;
    private String type;

    public HardDisk() {
    }

    public HardDisk(int storageSize, String type) {
        this.storageSize = storageSize;
        this.type = type;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}