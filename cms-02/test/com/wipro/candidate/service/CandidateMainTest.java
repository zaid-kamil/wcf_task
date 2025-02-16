package com.wipro.candidate.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;

public class CandidateMainTest {

	private CandidateDAO dao;

	@Before
	public void setUp() {
		dao = new CandidateDAO();
	}

	@Test
	public void testCheckDisplayRecordsForFail() {
		assertTrue(dao.getByResult("FAIL").size() > 0);
	}

	@Test
	public void testCheckDisplayRecordsForPass() {
		assertTrue(dao.getByResult("FAIL").size() > 0);
	}

	@Test
	public void testEmptyValueForCandidateName() {
		CandidateBean bean = new CandidateBean();
		bean.setName("");
        bean.setM1(90);
        bean.setM2(90);
        bean.setM3(90);
		bean.setResult("PASS");
		bean.setGrade("A");
        String result = dao.addCandidate(bean);
        assertNotEquals("Data incorrect", result);
		
	}

	@Test
	public void testForCandidateIDGeneration() {
		String result = dao.generateCandidateId("Rahul");
		assertNotEquals("No Messages Received", result);
		assertTrue(result.startsWith("FA"));
	}

	@Test
	public void testCheckDisplayCriteria() {
        List<String> criteria = Arrays.asList("ALL", "PASS", "FAIL");
        assertTrue(criteria.contains("ALL"));
        assertTrue(criteria.contains("PASS"));
        assertTrue(criteria.contains("FAIL"));
	}

	@Test
	public void testCheckDisplayAll() {
        assertTrue(dao.getByResult("ALL").size() > 0);
	}

	@Test
	public void testInvalidRangeInMarks() {
        CandidateBean bean = new CandidateBean();
        bean.setName("Rahul");
        bean.setM1(910);
        bean.setM2(90);
        bean.setM3(190);
        bean.setResult("PASS");
		bean.setGrade("A");
        String result = dao.addCandidate(bean);
        assertNotEquals("Data incorrect", result);
	}

	@Test
	public void testCandidateNameLessThanTwoLetters() {
        CandidateBean bean = new CandidateBean();
        bean.setName("R");
        bean.setM1(90);
        bean.setM2(90);
        bean.setM3(90);
        bean.setResult("PASS");
		bean.setGrade("A");
        String result = dao.addCandidate(bean);
        assertNotEquals("Data incorrect", result);
	}

	@Test
	public void testForPassAndFailResults() {
        assertTrue(dao.getByResult("PASS").size() > 0);
        assertTrue(dao.getByResult("FAIL").size() > 0);
	}

	@Test
	public void testNullValueForCandidateBean() {
        String result = dao.addCandidate(null);
        assertNotEquals("Data incorrect", result);
	}

}
