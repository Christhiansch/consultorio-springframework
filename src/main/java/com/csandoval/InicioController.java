package com.csandoval;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController
{

	@RequestMapping({"/", "/login", "/inicio"})
	public String inicio()
	{
		return "/web/layout";
	}
	
}
