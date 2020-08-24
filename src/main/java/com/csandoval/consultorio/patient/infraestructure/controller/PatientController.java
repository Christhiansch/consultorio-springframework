package com.csandoval.consultorio.patient.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController
{
	
	@Autowired
	private IPatientService patientService;
	
	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Patient> patients = patientService.listAll();
		model.put("patients", patients);
		return "patient/index";
	}
	
	@GetMapping("/create")
	public String create()
	{
		return "patient/create";
	}
	
	@PostMapping
	public String store()
	{
		return "patient/index";
	}
	
	@DeleteMapping("/delete")
	public String delete()
	{
		return "patient/index";
	}
}
