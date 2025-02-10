package com.automobile;

import com.automobile.fourwheeler.Ford;
import com.automobile.fourwheeler.Logan;
import com.automobile.twowheeler.Hero;
import com.automobile.twowheeler.Honda;

public class VehicleDemo {
    public static void main(String[] args) {
        // Testing Two Wheelers
        Hero hero = new Hero("Splendor Plus", "KA01AB1234", "John Doe");
        System.out.println("Hero Details:");
        System.out.println("Model Name: " + hero.getModelName());
        System.out.println("Registration Number: " + hero.getRegistrationNumber());
        System.out.println("Owner Name: " + hero.getOwnerName());
        System.out.println("Current Speed: " + hero.getSpeed());
        hero.radio();
        System.out.println();

        Honda honda = new Honda("CBR", "KA02CD5678", "Jane Doe");
        System.out.println("Honda Details:");
        System.out.println("Model Name: " + honda.getModelName());
        System.out.println("Registration Number: " + honda.getRegistrationNumber());
        System.out.println("Owner Name: " + honda.getOwnerName());
        System.out.println("Current Speed: " + honda.getSpeed());
        honda.cdplayer();
        System.out.println();

        // Testing Four Wheelers
        Logan logan = new Logan("Logan R", "MH02EF9012", "Alice Smith");
        System.out.println("Logan Details:");
        System.out.println("Model Name: " + logan.getModelName());
        System.out.println("Registration Number: " + logan.getRegistrationNumber());
        System.out.println("Owner Name: " + logan.getOwnerName());
        System.out.println("Current Speed: " + logan.speed());
        logan.gps();
        System.out.println();

        Ford ford = new Ford("Mustang", "DL03GH3456", "Bob Wilson");
        System.out.println("Ford Details:");
        System.out.println("Model Name: " + ford.getModelName());
        System.out.println("Registration Number: " + ford.getRegistrationNumber());
        System.out.println("Owner Name: " + ford.getOwnerName());
        System.out.println("Current Speed: " + ford.speed());
        ford.tempControl();
    }
}