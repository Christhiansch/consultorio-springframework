package com.csandoval.consultorio.specialty.infraestructure.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/specialties")
public class SpecialtyController
{

	@Autowired
	private ISpecialtyService specialtyService;
	
	@ModelAttribute("modulo")
	public String modulo()
	{
		return "specialty";
	}
	
	@ModelAttribute("menu")
	public String menu()
	{
		return "mantenimiento";
	}
	
	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Specialty> specialties = specialtyService.listAll().stream()
				.sorted(Comparator.comparingInt(Specialty::getId))
				.collect(Collectors.toList());
		model.put("specialties", specialties);
		return "specialties/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		model.put("specialty", new Specialty());
		return "specialties/form";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		Specialty specialty = specialtyService.findById(id);
		model.put("specialty", specialty);
		return "specialties/form-update";
	}
	
	@PostMapping("/store")
	public String store(ModelMap model, Specialty entity) throws Exception
	{
		String page = "";
		Specialty specialty = specialtyService.create(entity);
		if(specialty != null)
		{
			page = "redirect:/specialties";
		}
		else
		{
			model.put("specialty", entity);
			page = "specialties/form";			
		}
		return page;
	}
	
	@PostMapping("/update/{id}")
	public String update(ModelMap model, @PathVariable Integer id, Specialty entity)
	{
		String page = "";
		try
		{
			specialtyService.edit(entity);
			page = "redirect:/specialties";
		} catch (Exception e)
		{
			page = "redirect:/specialties/edit/" + entity.getId() ;
			e.printStackTrace();
		}
		return page;
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) throws Exception
	{
		specialtyService.delete(id);
		return "redirect:/specialties";
	}
	
}
