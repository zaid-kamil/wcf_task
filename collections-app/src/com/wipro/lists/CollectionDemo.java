package com.wipro.lists;

import java.util.*;

public class CollectionDemo {
    private List<String> stringList;
    private Set<Integer> numberSet;
    private Map<String, Integer> scoreMap;

    public CollectionDemo() {
        stringList = new ArrayList<>();
        numberSet = new HashSet<>();
        scoreMap = new HashMap<>();
    }

    public void addStrings(String... strings) {
        stringList.addAll(Arrays.asList(strings));
    }

    public void addNumbers(Integer... numbers) {
        numberSet.addAll(Arrays.asList(numbers));
    }

    public void addScore(String name, int score) {
        scoreMap.put(name, score);
    }

    public void displayAll() {
        System.out.println("Strings in List:");
        stringList.forEach(str -> System.out.println("- " + str));

        System.out.println("\nNumbers in Set:");
        numberSet.forEach(num -> System.out.println("- " + num));

        System.out.println("\nScores in Map:");
        scoreMap.forEach((name, score) -> 
            System.out.println("- " + name + ": " + score));
    }

    public static void main(String[] args) {
        CollectionDemo demo = new CollectionDemo();

        // Adding sample data
        demo.addStrings("Apple", "Banana", "Orange");
        demo.addNumbers(1, 2, 3, 2, 1, 4);  // Note: duplicates will be removed in Set
        demo.addScore("John", 85);
        demo.addScore("Alice", 92);
        demo.addScore("Bob", 78);

        // Display all collections
        demo.displayAll();
    }
}