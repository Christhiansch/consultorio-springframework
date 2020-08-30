package com.csandoval.consultorio.user.infraestructure.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.user.application.IUserService;
//import com.csandoval.consultorio.user.domain.User;

@Service
public class UserSecurityService implements UserDetailsService
{

	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		String user = userService.findByUsername(username).getUsername();
		String pass = userService.findByUsername(username).getPassword();
		
		Collection<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userdetail = new User(user, pass, roles);
		return userdetail;
	}

}
