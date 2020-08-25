package com.csandoval.consultasmedicas.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.csandoval.consultorio.doctor.application.IDoctorService;
import com.csandoval.consultorio.doctor.domain.Doctor;
import com.csandoval.consultorio.specialty.application.ISpecialtyService;
import com.csandoval.consultorio.specialty.domain.Specialty;
import com.github.javafaker.Faker;

@SpringBootTest
@ContextConfiguration
public class DoctorServiceTest
{

	private Faker faker = new Faker();
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired 
	private ISpecialtyService specialtyService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceTest.class);
	
	@Test
	public void createDoctor() throws Exception
	{

		String dni = faker.code().gtin8();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String medicalCode = faker.code().isbn10();
		
		int specialty_id = faker.number().numberBetween(1, specialtyService.listAll().size());		
		Specialty specialty = specialtyService.findById(specialty_id);
		
		Doctor doctor = doctorService.create(new Doctor(firstName, lastName, dni, medicalCode, specialty));
		assertTrue(doctor != null, "Doctor Registrado");
		
		LOGGER.info("Doctor: " + doctor.getFirstName() + " " + doctor.getLastName());
	}

	@Test
	@Disabled
	public void listDoctors()
	{

	}

	@Test
	@Disabled
	public void editDoctor()
	{

	}

	@Test
	@Disabled
	public void deleteDoctor()
	{

	}
}
