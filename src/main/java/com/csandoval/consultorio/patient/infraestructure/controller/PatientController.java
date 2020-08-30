package com.csandoval.consultorio.patient.infraestructure.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;

@Controller
@RequestMapping("/patients")
public class PatientController
{

	@Autowired
	private IPatientService patientService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);


	@ModelAttribute("modulo")
	public String modulo()
	{
		return "patient";
	}
	
	@ModelAttribute("menu")
	public String menu()
	{
		return "mantenimiento";
	}

	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Patient> patients = patientService.listAll().stream()
				.sorted(Comparator.comparingInt(Patient::getId))
				.collect(Collectors.toList());
		model.put("patients", patients);
		return "patients/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		model.put("patient", new Patient());
		return "patients/form";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		String page = "";
		Patient patient = patientService.findById(id);
				
		if(patient!=null)
		{
			model.put("patient", patient);
			page = "/patients/form-update";
		}
		else
		{
			page = "redirect:/patients";
		}
		return page;
	}

	@PostMapping("/store")
	public String store(ModelMap model, Patient entity)
	{
		String page = "";
		try
		{
			patientService.create(entity);
			page = "redirect:/patients";
		} catch (Exception e)
		{
			model.put("patient", entity);
			page = "redirect:/patients/form";
			e.printStackTrace();
		}		
		return page;
	}
	
	@PostMapping("/update/{id}")
	public String update(ModelMap model, @PathVariable Integer id, Patient entity)
	{
		String page = "";
		try
		{
			patientService.edit(entity);			
			page = "redirect:/patients";
		} catch (Exception e)
		{
			model.put("patient", entity);
			page = "redirect:/patients/edit/" + entity.getId() + "";
			e.printStackTrace();
		}
		
		return page;
	}

	@PostMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable Integer id) throws Exception
	{
//		LOGGER.info("Eliminar paciente con ID: " + id);
//		String response = "Se elimino correctamente"; 
		//patientService.delete(id);
//		return ResponseEntity.ok().body("message: " + response);
		patientService.delete(id);
		return "redirect:/patients";
	}
	
	@GetMapping("/search")
	public String searchPatient(
			@RequestParam(name="dni", required=false) String dni, 
			@RequestParam(name="firstname", required=false) String firstname)
	{
		Patient patient = patientService.findByDniOrFirstname(dni, firstname);
		LOGGER.info("Patient: " + patient.getDNI());
		
		return "consultation/form";
	}
}
