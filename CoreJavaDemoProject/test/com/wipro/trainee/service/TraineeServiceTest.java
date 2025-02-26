package com.wipro.trainee.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wipro.trainee.model.Trainee;

public class TraineeServiceTest {

	TraineeService service;

	@Before
	public void setUp() throws Exception {
		service = new TraineeService();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testAddTrainee() {
		Trainee trainee = service.addTrainee(new Trainee(1, "Aaaa", "WCF", "2832938298", "Aaaa@gmail.com"));
		assertNotNull(trainee);
	}
}
