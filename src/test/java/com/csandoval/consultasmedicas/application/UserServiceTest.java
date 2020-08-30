package com.csandoval.consultasmedicas.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.csandoval.consultorio.rol.application.IRoleService;
import com.csandoval.consultorio.rol.domain.Rol;
import com.csandoval.consultorio.user.application.IUsuarioService;
import com.csandoval.consultorio.user.domain.Usuario;
import com.github.javafaker.Faker;

@SpringBootTest
public class UserServiceTest
{

	private Faker faker = new Faker();
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired 
	private IRoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	public void createUserAdministrator() throws Exception
	{
		String username = faker.name().username();
		String password = "admin2020";
		String email = faker.internet().emailAddress();
		
		Rol role = roleService.findById(1);
		
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(bcrypt.encode(password));
		user.setState(true);
		user.setRole(role);
		
		Usuario result = userService.create(user);
		
		assertTrue(result != null, "No se registro el usuario");		
	}
	
	@Test
	public void createUserDoctor() throws Exception
	{
		String username = faker.name().username();
		String password = "admin2020";
		String email = faker.internet().emailAddress();
		
		Rol role = roleService.findById(2);
		
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(bcrypt.encode(password));
		user.setState(true);
		user.setRole(role);
		
		Usuario result = userService.create(user);
		
		assertTrue(result != null, "No se registro el usuario");		
	}
}
