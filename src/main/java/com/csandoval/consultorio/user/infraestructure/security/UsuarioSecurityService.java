package com.csandoval.consultorio.user.infraestructure.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.user.application.IUsuarioService;
import com.csandoval.consultorio.user.domain.Usuario;

@Service
public class UsuarioSecurityService implements UserDetailsService
{

	@Autowired
	private IUsuarioService usuarioService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioSecurityService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{

		Usuario usuario = usuarioService.findByUsername(username);
		LOGGER.info("Usuario: " + usuario.getUsername());
		
		Collection<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRole().getName()));
		LOGGER.info("Rol del Usuario: " + usuario.getRole().getName());
		
		UserDetails userdetail = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return userdetail;
	}

}
