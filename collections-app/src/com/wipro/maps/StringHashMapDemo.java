package com.wipro.maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringHashMapDemo {
    private HashMap<String, String> stringMap;

    public StringHashMapDemo() {
        stringMap = new HashMap<>();
    }

    // Add key-value pairs
    public void addItem(String key, String value) {
        stringMap.put(key, value);
    }

    // Check if key exists
    public boolean hasKey(String key) {
        return stringMap.containsKey(key);
    }

    // Check if value exists
    public boolean hasValue(String value) {
        return stringMap.containsValue(value);
    }

    // Iterate through the map
    public void displayMap() {
        System.out.println("\nIterating using Map.Entry:");
        Iterator<Map.Entry<String, String>> iterator = stringMap.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StringHashMapDemo demo = new StringHashMapDemo();

        // Add some key-value pairs
        demo.addItem("Java", "Programming Language");
        demo.addItem("Eclipse", "IDE");
        demo.addItem("Maven", "Build Tool");
        demo.addItem("Git", "Version Control");

        // Test key existence
        String searchKey = "Java";
        System.out.println("Does key '" + searchKey + "' exist? " + demo.hasKey(searchKey));
        System.out.println("Does key 'Python' exist? " + demo.hasKey("Python"));

        // Test value existence
        String searchValue = "IDE";
        System.out.println("\nDoes value '" + searchValue + "' exist? " + demo.hasValue(searchValue));
        System.out.println("Does value 'Database' exist? " + demo.hasValue("Database"));

        // Display all entries using iterator
        demo.displayMap();
    }
}