package com.csandoval.consultorio.web.infraestructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.csandoval.consultorio.user.application.IUsuarioService;
import com.csandoval.consultorio.user.domain.Usuario;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler
{
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private HttpSession session;
	
	private enum Roles{
		ADMIN, DOCTOR
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException
	{
		String url = "";
		String username = ((User) authentication.getPrincipal()).getUsername();
		Usuario usuario = usuarioService.findByUsername(username);
		
		if(usuario != null)
		{
			session.setAttribute("user", usuario);
		}
		
		for (GrantedAuthority authority : authentication.getAuthorities())
		{
			if(Roles.ADMIN == Roles.valueOf(authority.getAuthority()))
			{
				url = "/patients";
				break;
			}
			
			if(Roles.DOCTOR == Roles.valueOf(authority.getAuthority()))
			{
				url = "/home";
				break;
			}
		}
		
		
		new DefaultRedirectStrategy().sendRedirect(request, response, url);
	}

}
