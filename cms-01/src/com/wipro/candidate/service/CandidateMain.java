package com.wipro.candidate.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {

	/**
	 * @param args
	 */
	public String addCandidate(CandidateBean studBean) {
		String result = "";
		try {
			// validation
			if (studBean == null) {
				throw new WrongDataException();
			} else if (studBean.getName().isEmpty() || studBean.getName().length() < 2) {
				throw new WrongDataException();
			} else if ((studBean.getM1() < 0 || studBean.getM1() > 100)
					|| (studBean.getM2() < 0 || studBean.getM2() > 100)
					|| (studBean.getM3() < 0 || studBean.getM3() > 100)) {
				throw new WrongDataException();
			}

			// id generation
			CandidateDAO dao = new CandidateDAO();
			studBean.setId(dao.generateCandidateId(studBean.getName()));

			// result and grade generation
			int total = studBean.getM1() + studBean.getM2() + studBean.getM3();
			if (total >= 240) {
				studBean.setResult("PASS");
				studBean.setGrade("Distinction");
			} else if (total < 240 || total >= 180) {
				studBean.setResult("PASS");
				studBean.setGrade("First Class");
			} else if (total < 180 || total >= 150) {
				studBean.setResult("PASS");
				studBean.setGrade("Second Class");
			} else if (total < 150 || total >= 105) {
				studBean.setResult("PASS");
				studBean.setGrade("Third Class");
			} else if (total < 105) {
				studBean.setResult("FAIL");
				studBean.setGrade("No Grade");
			}

			// add to database
			String actionState = dao.addCandidate(studBean);
			if (actionState.equalsIgnoreCase("SUCCESS")) {
				result = studBean.getId() + ":" + studBean.getResult();
			} else {
				result = actionState;
			}
		} catch (WrongDataException | SQLException e) {
			return e.toString();
		}
		return result;

	}

	public ArrayList<CandidateBean> displayAll(String criteria) {
		List<String> criteriaList = List.of("ALL", "PASS", "FAIL");
		try {
			if (!criteriaList.contains(criteria)) {
				throw new WrongDataException();
			}
			CandidateDAO dao = new CandidateDAO();
			return dao.getByResult(criteria);
		} catch (WrongDataException e) {
			System.err.println(e.toString());
			return null;
		}
	}

	public static void main(String[] args) {
		CandidateMain cm = new CandidateMain();
		CandidateBean bean = cm.getCandidate();
		String result = cm.addCandidate(bean);
		System.out.println(result);
		cm.displayAll("ALL").stream().map(e -> e.getName()).forEach(System.out::println);

	}

	private CandidateBean getCandidate() {
		CandidateBean c = new CandidateBean();
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter candidate details");
			System.out.println("enter name:");
			c.setName(sc.nextLine());
			System.out.println("enter Marks 1:");
			int mark1 = Integer.parseInt(sc.nextLine());
			System.out.println("enter Marks 2:");
			int mark2 = Integer.parseInt(sc.nextLine());
			System.out.println("enter Marks 3:");
			int mark3 = Integer.parseInt(sc.nextLine());
			c.setM1(mark1);
			c.setM2(mark2);
			c.setM3(mark3);
			sc.close();
			return c;
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		return c;
	}

}
