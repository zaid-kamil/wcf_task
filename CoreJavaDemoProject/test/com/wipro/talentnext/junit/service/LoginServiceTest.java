/**
 * 
 */
package com.wipro.talentnext.junit.service;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wipro.talentnext.dto.User;
import com.wipro.talentnext.service.LoginService;

/**
 * 
 */
class LoginServiceTest {
	private User expectedUser;
	private LoginService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new LoginService();
	}

	@Test
	public void testValidateUser() {
		expectedUser = new User("Zaid", "Zaid");
		assertTrue(service.validateUser(expectedUser));
	}

	@Test
	public void testInvalidUser() {
		expectedUser = new User("Zaid", "123");
		assertFalse(service.validateUser(expectedUser));
	}
}
