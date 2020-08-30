package com.csandoval.consultorio.consultation.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csandoval.consultorio.consultation.application.service.IConsultationService;
import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;

@Controller
@RequestMapping("/consultations")
public class ConsultationController
{
	
	@Autowired
	private IConsultationService consultationService;
	
	@Autowired
	private IPatientService patientService;
	
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
	public String create(@PathVariable Integer id)
	{
		try
		{
			Patient patient = patientService.findById(id);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "form";
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
