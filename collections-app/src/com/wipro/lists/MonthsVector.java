package com.wipro.lists;

import java.util.Iterator;
import java.util.Vector;

public class MonthsVector {

    public static void main(String[] args) {
        // Create Vector to store months
        Vector<String> months = new Vector<>();

        // Add all months to the Vector
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        // Print using Iterator
        System.out.println("Months of the year using Iterator:");
        Iterator<String> iterator = months.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Print using enhanced for loop
        System.out.println("\nMonths of the year using for loop:");
        for (String month : months) {
            System.out.println(month);
        }

        // Demonstrating Vector specific methods
        System.out.println("\nVector size: " + months.size());
        System.out.println("Vector capacity: " + months.capacity());
        System.out.println("First element: " + months.firstElement());
        System.out.println("Last element: " + months.lastElement());
    }
}
