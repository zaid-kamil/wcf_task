package com.wipro.sets;

import java.util.HashSet;

public class CountryManager {
    private HashSet<String> H1;

    public CountryManager() {
        H1 = new HashSet<>();
    }

    public HashSet<String> saveCountryNames(String CountryName) {
        H1.add(CountryName);
        return H1;
    }

    public String getCountry(String CountryName) {
        for (String country : H1) {
            if (country.equalsIgnoreCase(CountryName)) {
                return country;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CountryManager manager = new CountryManager();

        // Adding countries
        manager.saveCountryNames("India");
        manager.saveCountryNames("USA");
        manager.saveCountryNames("Germany");
        manager.saveCountryNames("France");

        // Test the getCountry method
        System.out.println("Looking for USA: " + manager.getCountry("USA"));
        System.out.println("Looking for Japan: " + manager.getCountry("Japan"));

        // Display all countries in HashSet
        System.out.println("\nAll Countries in HashSet:");
        System.out.println(manager.H1);

        // Try adding duplicate country
        manager.saveCountryNames("India");
        System.out.println("\nAfter trying to add duplicate entry:");
        System.out.println(manager.H1);
    }
}