package com.wipro.maps;

import java.util.Properties;
import java.util.Iterator;
import java.util.Set;

public class StateCapitalProperties {
    private Properties stateCapitals;

    public StateCapitalProperties() {
        stateCapitals = new Properties();
        initializeStates();
    }

    private void initializeStates() {
        // Adding state-capital pairs
        stateCapitals.setProperty("Maharashtra", "Mumbai");
        stateCapitals.setProperty("Karnataka", "Bengaluru");
        stateCapitals.setProperty("Tamil Nadu", "Chennai");
        stateCapitals.setProperty("Gujarat", "Gandhinagar");
        stateCapitals.setProperty("Kerala", "Thiruvananthapuram");
    }

    public void listStates() {
        System.out.println("States and their Capitals:");
        System.out.println("=========================");

        // Get all property names (states)
        Set<String> states = stateCapitals.stringPropertyNames();
        Iterator<String> iterator = states.iterator();

        // Iterate and display state-capital pairs
        while (iterator.hasNext()) {
            String state = iterator.next();
            String capital = stateCapitals.getProperty(state);
            System.out.println(state + " -> " + capital);
        }
    }

    public static void main(String[] args) {
        StateCapitalProperties demo = new StateCapitalProperties();
        demo.listStates();

        // Additional operations demonstration
        Properties props = demo.stateCapitals;
        
        // Check if a state exists
        String searchState = "Karnataka";
        System.out.println("\nDoes " + searchState + " exist? " + 
            props.containsKey(searchState));

        // Get capital of a specific state
        System.out.println("Capital of " + searchState + " is: " + 
            props.getProperty(searchState));

        // Try to get non-existent state (with default value)
        System.out.println("Capital of Goa is: " + 
            props.getProperty("Goa", "Not Found"));
    }
}