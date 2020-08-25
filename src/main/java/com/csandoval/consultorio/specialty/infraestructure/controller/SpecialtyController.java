package com.csandoval.consultorio.specialty.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csandoval.consultorio.specialty.application.ISpecialtyService;
import com.csandoval.consultorio.specialty.domain.Specialty;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController
{

	@Autowired
	private ISpecialtyService specialtyService;
	
	@ModelAttribute("modulo")
	public String modulo()
	{
		return "specialty";
	}
	
	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Specialty> specialties = specialtyService.listAll();
		model.put("specialties", specialties);
		return "specialty/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		model.put("specialty", new Specialty());
		return "specialty/form";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		Specialty specialty = specialtyService.findById(id);
		model.put("specialty", specialty);
		return "specialty/form";
	}
	
	@PostMapping("/store")
	public String store(ModelMap model, Specialty entity) throws Exception
	{
		String page = "";
		Specialty specialty = specialtyService.create(entity);
		if(specialty != null)
		{
			page = "redirect:/specialty";
		}
		else
		{
			model.put("specialty", entity);
			page = "specialty/form";			
		}
		return page;
	}
	
	@PostMapping("/update")
	public String update(ModelMap model, Specialty entity)
	{
		return "";
	}
	
	@PostMapping("/delete")
	public String delete(@PathVariable Integer id) throws Exception
	{
		specialtyService.delete(id);
		return "redirect:/specialty";
	}
	
}
