package com.csandoval.consultorio.consultation.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@ModelAttribute("menu")
	public String menu()
	{
		return "consulta";
	}

	@GetMapping("/histories")
	public String index(ModelMap model) throws Exception
	{
		model.put("patients", patientService.listAll());
		return "consultations/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		try
		{
//			model.put("patient", new Patient());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "consultations/form";
	}
	
	@GetMapping("/report/{id}")
	public String downloadClinicalHistory(@PathVariable Integer id)
	{
		return "redirect:consultations/index";
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
