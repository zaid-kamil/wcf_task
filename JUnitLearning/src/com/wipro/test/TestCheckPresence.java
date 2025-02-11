package com.wipro.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.wipro.task.DailyTasks;

public class TestCheckPresence {
    @Test
    public void testCheckPresence() {
        DailyTasks tasks = new DailyTasks();
        
        // Test case 1: String present in middle
        assertTrue(tasks.checkPresence("Hello World", "World"));
        
        // Test case 2: String present at start
        assertTrue(tasks.checkPresence("Hello World", "Hello"));
        
        // Test case 3: String not present
        assertFalse(tasks.checkPresence("Hello World", "Java"));
        
        // Test case 4: Case sensitivity test
        assertFalse(tasks.checkPresence("Hello World", "world"));
        
        // Test case 5: Empty string search
        assertTrue(tasks.checkPresence("Hello World", ""));
        
        // Test case 6: Substring test
        assertTrue(tasks.checkPresence("Hello World", "llo"));
    }
}
