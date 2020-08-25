package com.csandoval.consultorio.patient.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;
import com.github.javafaker.Faker;

@Controller
@RequestMapping("/patient")
public class PatientController
{

	@Autowired
	private IPatientService patientService;
	
	private Faker faker = new Faker();

	@ModelAttribute("modulo")
	public String modulo()
	{
		return "patient";
	}

	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Patient> patients = patientService.listAll();
		model.put("patients", patients);
		return "patient/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		model.put("patient", new Patient());
		return "patient/create";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		String page = "";
		Patient patient = patientService.findById(id);
				
		if(patient!=null)
		{
			model.put("patient", patient);
			page = "/patient/create";
		}
		else
		{
			page = "redirect:/patient";
		}
		return page;
	}

	@PostMapping("/store")
	public String store(ModelMap model, Patient entity)
	{
		String page = "";
		entity.setNumberClinicalHistory(faker.code().isbn10());
		try
		{
			Patient patient = patientService.create(entity);
			model.put("patient", patient);
			page = "redirect:/patient";
		} catch (Exception e)
		{
			model.put("patient", entity);
			page = "redirect:/patient/create";
			e.printStackTrace();
		}

		
		return page;
	}
	
	@PostMapping("/update")
	public String update(ModelMap model, Patient entity)
	{
		String page = "";
		
		try
		{
			Patient patient = patientService.edit(entity);
			model.put("patient", patient);
			page = "redirect:/patient";
		} catch (Exception e)
		{
			model.put("patient", entity);
			page = "redirect:/patient/edit/{" + entity.getId() + "}";
			e.printStackTrace();
		}
		
		return page;
	}

	@PostMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable Integer id) throws Exception
	{
		patientService.delete(id);
		return "patient/index";
	}
}
