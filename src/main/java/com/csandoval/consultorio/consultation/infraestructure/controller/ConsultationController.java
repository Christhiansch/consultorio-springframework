package com.csandoval.consultorio.consultation.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csandoval.consultorio.consultation.application.service.IConsultationService;

@Controller
@RequestMapping("/consultations")
public class ConsultationController
{
	
	@Autowired
	private IConsultationService consultationService;
	
	@ModelAttribute("modulo")
	public String modulo()
	{
		return "consultation";
	}

	@GetMapping("/")
	public String index()
	{
		return "";
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "";
	}
	
	@GetMapping("/edit/{id}")
	public String edit()
	{
		return "";
	}
	
	@PostMapping("/store")
	public String store()
	{
		return "";
	}
	
	@PostMapping("/update")
	public String update()
	{
		return "";
	}
	
	@PostMapping("/delete")
	public String delete()
	{
		return "";
	}
}
