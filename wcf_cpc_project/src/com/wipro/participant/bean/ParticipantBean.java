package com.wipro.participant.bean;

public class ParticipantBean {

	private String id;
	private String name;
	private int theoryMark1;
	private int theoryMark2;
	private int practicalMark1;
	private int practicalMark2;
	private String sportsQuotaPresent;
	private int total;
	private String result;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTheoryMark1() {
		return theoryMark1;
	}

	public void setTheoryMark1(int theoryMark1) {
		this.theoryMark1 = theoryMark1;
	}

	public int getTheoryMark2() {
		return theoryMark2;
	}

	public void setTheoryMark2(int theoryMark2) {
		this.theoryMark2 = theoryMark2;
	}

	public int getPracticalMark1() {
		return practicalMark1;
	}

	public void setPracticalMark1(int practicalMark1) {
		this.practicalMark1 = practicalMark1;
	}

	public int getPracticalMark2() {
		return practicalMark2;
	}

	public void setPracticalMark2(int practicalMark2) {
		this.practicalMark2 = practicalMark2;
	}

	public String getSportsQuotaPresent() {
		return sportsQuotaPresent;
	}

	public void setSportsQuotaPresent(String sportsQuotaPresent) {
		this.sportsQuotaPresent = sportsQuotaPresent;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
