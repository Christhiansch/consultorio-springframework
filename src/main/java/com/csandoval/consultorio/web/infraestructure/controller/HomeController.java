package com.csandoval.consultorio.web.infraestructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{

	@RequestMapping({"/", "/login", "/inicio"})
	public String inicio()
	{
		return "/web/layout";
	}
	
}
