package com.wipro.talentnext.junit.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wipro.talentnext.Calculator;

public class CalculatorTest {
	public Calculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new Calculator();	
		calc.setName("WCF");
		System.out.println("setup called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown called");
	}

	@Test
	public void testAdd() {
		int expectedOutput = 4;
		int actualOutput = calc.add(2, 2);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testGetName() {
		String expectedOutput = "WCF";
		String actualOutput = calc.getName();
		assertEquals(expectedOutput, actualOutput);
	}

}
