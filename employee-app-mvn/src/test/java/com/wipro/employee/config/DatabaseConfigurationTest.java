package com.wipro.employee.config;

import static com.wipro.employee.config.DatabaseConfiguration.checkDriver;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseConfigurationTest {
	
	DatabaseConfiguration dbc;

	@Test
	public void testGetConnection() {
		boolean actualOutput = checkDriver(DatabaseConfiguration.URL);
		assertFalse(actualOutput);
	}
}
