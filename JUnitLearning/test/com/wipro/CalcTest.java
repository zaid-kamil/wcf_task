package com.wipro;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

	Calc c;

	@Before
	public void setUp() throws Exception {
		c = new Calc();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testAdd() {
		int expected = 10;
		int actual = c.add(5, 5);
		assertEquals(expected, actual);
	}

}
