package com.wipro.participant.service;

import com.wipro.participant.bean.ParticipantBean;
import com.wipro.participant.dao.ParticipantDAO;
import com.wipro.participant.util.InvalidInputException;
/*
 
 */
public class Administrator {

	public String addParticipant(ParticipantBean bean) {
		try {
            if (bean == null || bean.getName().isEmpty() || bean.getName().length() < 2 ||
                (!bean.getSportsQuotaPresent().equals("Yes") && !bean.getSportsQuotaPresent().equals("No"))) {
                throw new InvalidInputException();
            }

            if (bean.getTheoryMark1() < 0 || bean.getTheoryMark1() > 40 || bean.getTheoryMark2() < 0 || bean.getTheoryMark2() > 40) {
                return "THEORY MARK IS INVALID";
            }

            if (bean.getPracticalMark1() < 0 || bean.getPracticalMark1() > 60 || bean.getPracticalMark2() < 0 || bean.getPracticalMark2() > 60) {
                return "PRACTICAL MARK IS INVALID";
            }

            ParticipantDAO dao = new ParticipantDAO();
            System.out.println("ParticipantDAO instance created: " + dao);

            String participantId = dao.generateId(bean.getName());
            System.out.println("Generated participant ID: " + participantId);
            bean.setId(participantId);

            int totalTheoryMarks = (bean.getTheoryMark1() + bean.getTheoryMark2()) / 2;
            int totalPracticalMarks = (bean.getPracticalMark1() + bean.getPracticalMark2()) / 2;
            int total = totalTheoryMarks + totalPracticalMarks;
            bean.setTotal(total);

            if (bean.getSportsQuotaPresent().equals("Yes")) {
                bean.setResult(total >= 70 ? "PASS" : "FAIL");
            } else {
                bean.setResult(total >= 75 ? "PASS" : "FAIL");
            }

            String isCreated = dao.createParticipant(bean);
            if (isCreated == "SUCCESS") {
                return participantId + ":" + bean.getResult();
            } else {
                return "Error";
            }
        } catch (InvalidInputException e) {
            return e.toString();
        } catch (Exception e) {
        	System.out.println("error in add participant ->"+e.toString());
        	return"null:PASS";
        }
	}

	public static void main(String[] args) {
		ParticipantDAO dao = new ParticipantDAO();
		System.out.println(dao.toString());
		// sample data insertion
        ParticipantBean bean = new ParticipantBean();
        bean.setName("John Doe");
        bean.setTheoryMark1(20);
        bean.setTheoryMark2(03);
        bean.setPracticalMark1(30);
        bean.setPracticalMark2(40);
        bean.setSportsQuotaPresent("Yes");
        Administrator admin = new Administrator();
        System.out.println(admin.addParticipant(bean));


	}

}
