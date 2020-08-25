package com.csandoval.consultasmedicas.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.csandoval.consultorio.specialty.application.ISpecialtyService;
import com.csandoval.consultorio.specialty.domain.Specialty;
import com.github.javafaker.Faker;

@SpringBootTest
@ContextConfiguration
public class SpecialtyServiceTest
{

	private Faker faker = new Faker();
	@Autowired
	private ISpecialtyService specialtyService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpecialtyServiceTest.class);
	
	@Test
	public void createSpecialty() throws Exception
	{
		for (int i = 0; i < 10; i++)
		{
			String name = faker.name().title();
			Specialty specialty = specialtyService.create(new Specialty(name));
			assertTrue(specialty != null, "Especialidad registrada: " + specialty.getName());
		}
	}
	
	@Test
	public void listSpecialties() throws Exception
	{
		List<Specialty> specialties = specialtyService.listAll();
		assertTrue(specialties.size() > 0, "Lista de especialidades obtenida");
	}
	
	@Test
	public void editSpecialty() throws Exception
	{
		int id = faker.number().numberBetween(1, totalSpecialties());
		Specialty specialty = specialtyService.findById(id);
		LOGGER.info("Nro: " + specialty.getId() + " - " + specialty.getName());
		
		String name = faker.name().title();
		specialty.setName(name);
		specialty = specialtyService.edit(specialty);
		
		assertTrue(specialty != null, "Especialidad editada");
		LOGGER.info("Nro: " + specialty.getId() + " - " + specialty.getName());
	}
	
	@Test
	public void deleteSpecialty() throws Exception
	{
		int id = faker.number().numberBetween(1, totalSpecialties());
		specialtyService.delete(id);
		assertTrue(id > 0, "Se elimino la especialidad con nro ID: " + id);
	}
	
	public int totalSpecialties()
	{
		int total = 0;
		try
		{
			total = specialtyService.listAll().size();
		} catch (Exception e)
		{
			e.printStackTrace();
			LOGGER.error("Ocurrio un error al listar todas las especialidades");
		}
		return total;
	}
}
