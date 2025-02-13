package com.wipro.sets;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        // Create TreeSet and add elements
        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Date");
        treeSet.add("Elderberry");

        // Print original order
        System.out.println("Original TreeSet:");
        printSet(treeSet);

        // a) Reverse the elements
        System.out.println("\nReversed TreeSet:");
        NavigableSet<String> reverseSet = treeSet.descendingSet();
        printSet(reverseSet);

        // b) Iterate using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
        }

        // c) Check if elements exist
        String searchElement1 = "Cherry";
        String searchElement2 = "Fig";

        System.out.println("\nSearching for elements:");
        System.out.println("Is '" + searchElement1 + "' present? " + treeSet.contains(searchElement1));
        System.out.println("Is '" + searchElement2 + "' present? " + treeSet.contains(searchElement2));
    }

    private static void printSet(Iterable<String> set) {
        for (String element : set) {
            System.out.println(element);
        }
    }
}
