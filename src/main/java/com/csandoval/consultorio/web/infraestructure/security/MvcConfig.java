package com.csandoval.consultorio.web.infraestructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/auth/login").setViewName("/auth/login");
		registry.addViewController("/home").setViewName("/web/layout");
	}
	
	

}
