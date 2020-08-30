package com.csandoval.consultasmedicas.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.csandoval.consultorio.user.application.IUserService;
import com.csandoval.consultorio.user.domain.User;
import com.github.javafaker.Faker;

@SpringBootTest
public class UserServiceTest
{

	private Faker faker = new Faker();
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	public void create() throws Exception
	{
		String username = faker.name().username();
		String password = "admin2020";
		String email = faker.internet().emailAddress();
		
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(bcrypt.encode(password));
		user.setState(true);
		
		User result = userService.create(user);
		
		assertTrue(result != null, "Se registro el usuario");
		
	}
}
