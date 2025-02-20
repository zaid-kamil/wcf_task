package com.wipro.talentnext.dto;

public class User {
	private String username, password;
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
