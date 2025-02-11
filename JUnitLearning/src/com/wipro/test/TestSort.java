package com.wipro.test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.wipro.task.DailyTasks;

public class TestSort {
    @Test
    public void testSortValues() {
        DailyTasks tasks = new DailyTasks();
        
        // Test case 1: Regular array
        int[] input1 = {5, 3, 1, 4, 2};
        int[] expected1 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected1, tasks.sortValues(input1));
        
        // Test case 2: Array with duplicates
        int[] input2 = {3, 3, 1, 1, 2};
        int[] expected2 = {1, 1, 2, 3, 3};
        assertArrayEquals(expected2, tasks.sortValues(input2));
        
        // Test case 3: Already sorted array
        int[] input3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected3, tasks.sortValues(input3));
        
        // Test case 4: Empty array
        int[] input4 = {};
        int[] expected4 = {};
        assertArrayEquals(expected4, tasks.sortValues(input4));
    }
}
