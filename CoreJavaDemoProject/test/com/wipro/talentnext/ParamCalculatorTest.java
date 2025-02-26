package com.wipro.talentnext;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamCalculatorTest {
	int expected;
	int input1;
	int input2;
	// class object
	private Calculator calc;

	// first parameter is expected, and rest are inputs
	public ParamCalculatorTest(int expected, int input1, int input2) {
		super();
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Before
	public void init() {
		System.out.println("Init called");
		calc = new Calculator();
	}
	
	@Parameters
	public static Collection<Object[]> testParameters(){
		Object[][] object = new Object[][] {
			{4,2,2}, {5,3,2}, {10,6,4}, {50, 25, 25}
		};
		return Arrays.asList(object);
	}
	
	@Test
	public void testAdd() {
		assertEquals(expected, calc.add(input1, input2));
	}
	
	@After
	public void destroy() {
		calc = null;
	}
}
