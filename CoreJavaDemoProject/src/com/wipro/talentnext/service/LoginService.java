package com.wipro.talentnext.service;

import com.wipro.talentnext.dto.User;

public class LoginService {
	public boolean validateUser(User user) {
		if (user.getUsername().equals(user.getPassword()))
			return true;
		return false;
	}
	public void arithmeticCalc() {
		int c = 5/0;
	}
}
