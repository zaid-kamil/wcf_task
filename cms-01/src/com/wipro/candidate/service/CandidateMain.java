package com.wipro.candidate.service;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;
import java.util.ArrayList;
import java.util.List;

public class CandidateMain {

	/**
	 * @param args
	 */
//	public String addCandidate(CandidateBean studBean) {
//		String result = "";
//		try {
//			// validation
//			if (studBean == null || studBean.getName().isEmpty() || studBean.getName().length() < 2 ||
//				studBean.getM1() < 0 || studBean.getM1() > 100 ||
//				studBean.getM2() < 0 || studBean.getM2() > 100 ||
//				studBean.getM3() < 0 || studBean.getM3() > 100) {
//				throw new WrongDataException();
//			}
//
//			// id generation
//			CandidateDAO dao = new CandidateDAO();
//			studBean.setId(dao.generateCandidateId(studBean.getName()));
//
//			// result and grade generation
//			int total = studBean.getM1() + studBean.getM2() + studBean.getM3();
//			if (total >= 240) {
//				studBean.setResult("PASS");
//				studBean.setGrade("Distinction");
//			} else if (total >= 180) {
//				studBean.setResult("PASS");
//				studBean.setGrade("First Class");
//			} else if (total >= 150) {
//				studBean.setResult("PASS");
//				studBean.setGrade("Second Class");
//			} else if (total >= 105) {
//				studBean.setResult("PASS");
//				studBean.setGrade("Third Class");
//			} else {
//				studBean.setResult("FAIL");
//				studBean.setGrade("No Grade");
//			}
//
//			// add to database
//			String actionState = dao.addCandidate(studBean);
//			result = actionState.equalsIgnoreCase("SUCCESS") ? studBean.getId() + ":" + studBean.getResult() : actionState;
//		} catch (WrongDataException e) {
//			return "Data incorrect";
//		}
//		return result;
//	}
//
//	public ArrayList<CandidateBean> displayAll(String criteria) {
//		List<String> criteriaList = List.of("ALL", "PASS", "FAIL");
//		try {
//			if (!criteriaList.contains(criteria)) {
//				throw new WrongDataException();
//			}
//			CandidateDAO dao = new CandidateDAO();
//			return dao.getByResult(criteria);
//		} catch (WrongDataException e) {
//			return null;
//		}
//	}
//
	public static void main(String[] args) {
		CandidateMain cm = new CandidateMain();


//		String out = "";
//		CandidateBean bean = new CandidateBean();
//		bean.setName("John Doe");
//		bean.setM1(85);
//		bean.setM2(90);
//		bean.setM3(95);
//		out = cm.addCandidate(bean);
//		System.out.println("Correct Data -> "+ out);
//
//		
//
//		// check for invalid name
//		CandidateBean bean2 = new CandidateBean();
//		bean2.setName("J");
//		bean2.setM1(85);
//		bean2.setM2(90);
//		bean2.setM3(95);
//		out = cm.addCandidate(bean2);
//		System.out.println("Invalid Name -> "+ out);
//
//		
//		// check for invalid marks
//		CandidateBean bean3 = new CandidateBean();
//		bean3.setName("John Doe");
//		bean3.setM1(85);
//		bean3.setM2(90);
//		bean3.setM3(105);
//		out = cm.addCandidate(bean3);
//		System.out.println("Invalid Marks -> "+ out);
//
//		// check for invalid data
//		CandidateBean bean4 = new CandidateBean();
//		bean4.setName("");
//		bean4.setM1(85);
//		bean4.setM2(90);
//		bean4.setM3(105);
//		out = cm.addCandidate(bean4);
//		System.out.println("Invalid Data -> "+ out);
//
//		// check for null data
//		out = cm.addCandidate(null);
//		System.out.println("Null Data -> "+ out);
//		
//		// display
//		ArrayList<CandidateBean> candidates = cm.displayAll("ALL");
//		if (candidates != null) {
//			System.out.println("Display All");
//			candidates.stream().map(e -> e.getId() + ":" + e.getName()+"||").forEach(System.out::print);
//			System.out.println();
//		}
//
//		ArrayList<CandidateBean> candidates2 = cm.displayAll("PASS");
//		if (candidates2 != null) {
//			System.out.println("Display Pass");
//			candidates2.stream().map(e -> e.getId() + ":" + e.getName()+"||").forEach(System.out::print);
//			System.out.println();
//		}
//
//		ArrayList<CandidateBean> candidates3 = cm.displayAll("FAIL");
//		if (candidates3 != null) {
//			System.out.println("Display Fail");
//			candidates3.stream().map(e -> e.getId() + ":" + e.getName()+"||").forEach(System.out::print);
//			System.out.println();
//		}
//
//		// check for invalid criteria
//		ArrayList<CandidateBean> candidates4 = cm.displayAll("INVALID");
//		if (candidates4 != null) {
//			candidates4.stream().map(e -> e.getId() + ":" + e.getName()+"||").forEach(System.out::print);
//		}else{
//			System.out.println("Invalid criteria");
//		}

	}
}
