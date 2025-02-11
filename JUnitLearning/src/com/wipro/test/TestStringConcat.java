package com.wipro.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.wipro.task.DailyTasks;

public class TestStringConcat {
    @Test
    public void testDoStringConcat() {
        DailyTasks tasks = new DailyTasks();
        
        // Test case 1: Regular strings
        String result1 = tasks.doStringConcat("Hello", "World");
        assertEquals("Hello World", result1);
        
        // Test case 2: Empty strings
        String result2 = tasks.doStringConcat("", "");
        assertEquals(" ", result2);
        
        // Test case 3: One empty string
        String result3 = tasks.doStringConcat("Hello", "");
        assertEquals("Hello ", result3);
    }
}