package com.csandoval.consultorio.doctor.infraestructure;

import java.util.List;

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

@Controller
@RequestMapping("/doctor")
public class DoctorController
{
	
	@Autowired
	private IDoctorService doctorService;
	
	@ModelAttribute("modulo")
	public String modulo()
	{
		return "doctor";
	}
	
	@GetMapping("")
	public String index(ModelMap model) throws Exception
	{
		List<Doctor> doctors = doctorService.listAll();
		model.put("doctor", doctors);
		return "doctor/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model)
	{
		model.put("doctor", new Doctor());
		return "doctor/form";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable Integer id) throws Exception
	{
		Doctor doctor = doctorService.findById(id);
		model.put("doctor", doctor);
		return "doctor/form";
	}
	
	@PostMapping("/store")
	public String store(Doctor entity) throws Exception
	{
		String page = "";
		
		Doctor doctor = doctorService.create(entity);
		if(doctor != null)
		{
			page = "redirect:/doctor";
		}
		else
		{
			page = "doctor/form";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String update(Doctor entity)
	{
		String page = "";
		
		return page;
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) throws Exception
	{
		doctorService.delete(id);
		return "redirect:/doctor";
	}
}
