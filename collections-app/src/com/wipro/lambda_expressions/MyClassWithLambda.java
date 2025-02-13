package com.wipro.lambda_expressions;

public class MyClassWithLambda {
    public static void main(String[] args) {
        // Implementing count method using lambda expression
        WordCount counter = str -> {
            if (str == null || str.trim().isEmpty()) {
                return 0;
            }
            return str.trim().split("\\s+").length;
        };

        // Test cases
        String test1 = "Hello World Java Programming";
        String test2 = "Lambda   Expressions are   powerful";
        String test3 = "";
        String test4 = null;

        // Display results
        System.out.println("Test String 1: \"" + test1 + "\"");
        System.out.println("Word Count: " + counter.count(test1));

        System.out.println("\nTest String 2: \"" + test2 + "\"");
        System.out.println("Word Count: " + counter.count(test2));

        System.out.println("\nTest String 3 (empty): \"" + test3 + "\"");
        System.out.println("Word Count: " + counter.count(test3));

        System.out.println("\nTest String 4 (null)");
        System.out.println("Word Count: " + counter.count(test4));
    }
}