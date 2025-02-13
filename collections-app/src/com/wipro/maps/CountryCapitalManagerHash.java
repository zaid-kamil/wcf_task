package com.wipro.maps;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class CountryCapitalManagerHash {
	private Hashtable<String, String> M1;

	public CountryCapitalManagerHash() {
		M1 = new Hashtable<>();
	}

	// 1. Save country and capital
	public Map<String, String> saveCountryCapital(String countryName, String capital) {
		M1.put(countryName, capital);
		return M1;
	}

	// 2. Get capital by country name
	public String getCapital(String countryName) {
		return M1.get(countryName);
	}

	// 3. Get country by capital name
	public String getCountry(String capitalName) {
		for (Map.Entry<String, String> entry : M1.entrySet()) {
			if (entry.getValue().equals(capitalName)) {
				return entry.getKey();
			}
		}
		return null;
	}

	// 4. Create new map with capital as key and country as value
	public Map<String, String> swapKeyValue() {
		Hashtable<String, String> M2 = new Hashtable<>();
		for (Map.Entry<String, String> entry : M1.entrySet()) {
			M2.put(entry.getValue(), entry.getKey());
		}
		return M2;
	}

	// 5. Create ArrayList of country names
	public ArrayList<String> getCountries() {
		return new ArrayList<>(M1.keySet());
	}

	public static void main(String[] args) {
		CountryCapitalManagerHash manager = new CountryCapitalManagerHash();

		try {
			// Adding country-capital pairs
			manager.saveCountryCapital("India", "Delhi");
			manager.saveCountryCapital("Japan", "Tokyo");
			manager.saveCountryCapital("USA", "Washington D.C.");
			manager.saveCountryCapital("France", "Paris");
			manager.saveCountryCapital("Germany", "Berlin");

			// Test getCapital method
			System.out.println("Capital of India: " + manager.getCapital("India"));

			// Test getCountry method
			System.out.println("Country with capital Tokyo: " + manager.getCountry("Tokyo"));

			// Test swapped map (M2)
			System.out.println("\nSwapped Map (Capital -> Country):");
			Map<String, String> M2 = manager.swapKeyValue();
			for (Map.Entry<String, String> entry : M2.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}

			// Test ArrayList of countries
			System.out.println("\nList of Countries:");
			ArrayList<String> countries = manager.getCountries();
			for (String country : countries) {
				System.out.println(country);
			}

		} catch (NullPointerException e) {
			System.out.println("Error: Null values are not allowed in Hashtable");
		}
	}
}