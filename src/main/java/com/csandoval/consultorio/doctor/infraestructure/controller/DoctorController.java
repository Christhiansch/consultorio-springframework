package com.csandoval.consultorio.doctor.infraestructure.controller;

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

import com.csandoval.consultorio.doctor.application.IDoctorService;
import com.csandoval.consultorio.doctor.domain.Doctor;
import com.csandoval.consultorio.specialty.application.ISpecialtyService;

@Controller
@RequestMapping("/doctors")
public class DoctorController
{
	@Autowired
	private ISpecialtyService specialtyService;
	
	@Autowired
	private IDoctorService doctorService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	@ModelAttribute("modulo")
	public String modulo()
	{
		return "doctor";
	}
	
	@ModelAttribute("menu")
	public String menu()
	{
		return "mantenimiento";
	}
	
	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Doctor> doctors = doctorService.listAll().stream()
				.sorted(Comparator.comparingInt(Doctor::getId))
				.collect(Collectors.toList());		
		model.put("doctors", doctors);
		return "doctors/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) throws Exception
	{
		model.put("doctor", new Doctor());
		model.put("specialties", specialtyService.listAll());
		return "doctors/form";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		Doctor doctor = doctorService.findById(id);
		model.put("doctor", doctor);
		model.put("specialties", specialtyService.listAll());
		return "doctors/form-update";
	}
	
	@PostMapping("/store")
	public String store(Doctor entity) throws Exception
	{
		String page = "";
		Doctor doctor = doctorService.create(entity);
		if(doctor != null)
		{
			page = "redirect:/doctors";
		}
		else
		{
			page = "redirect:/doctors/create";
		}
		
		return page;
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable Integer id, Doctor entity)
	{
		String page = "";
		try
		{
			doctorService.edit(entity);
			page = "redirect:/doctors";
		} catch (Exception e)
		{
			page = "redirect:/doctors/edit/" + entity.getId();
			e.printStackTrace();
		}
		return page;
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) throws Exception
	{
		doctorService.delete(id);
		return "redirect:/doctors";
	}
}
