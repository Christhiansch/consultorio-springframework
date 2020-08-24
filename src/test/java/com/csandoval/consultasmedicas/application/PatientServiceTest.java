package com.csandoval.consultasmedicas.application;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;
import com.github.javafaker.Faker;

@SpringBootTest
@ContextConfiguration
public class PatientServiceTest
{

	@Autowired
	private IPatientService patientService;

	private Faker data = new Faker();
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceTest.class);

	@Test
	public void createPatient() throws Exception
	{

		for (int i = 0; i < 10; i++)
		{
			String firstName = data.name().firstName();
			String lastName = data.name().lastName();
			String DNI = data.code().ean8();
			String numberClinicalHistory = data.code().isbn10();

			Patient dataResult = patientService.create(new Patient(firstName, lastName, DNI, numberClinicalHistory));
			Assert.isTrue(dataResult != null, "Paciente registrado con exito");
			LOGGER.info(dataResult.getFirstName() + " " + dataResult.getLastName());
		}
	}

	@Test
	public void listAllPatients() throws Exception
	{
		List<Patient> patients = patientService.listAll();
		Assert.isTrue(patients.size() > 0, "Result: Existe una lista de todos los pacientes");
		patients.forEach(patient -> LOGGER.info(patient.getFirstName() + " " + patient.getLastName()));
	}
	
	@Test
	public void editPatientById() throws Exception
	{
		int id = data.number().numberBetween(1, 31);
		Patient patient = patientService.findById(id);
		
		Assert.isTrue(patient != null, "Result: " + patient.toString());
		
		patient.setDNI(data.code().ean8());
		patient.setFirstName(data.name().firstName());
		patient.setLastName(data.name().lastName());
		patient.setNumberClinicalHistory(data.code().isbn10());
		
		patient = patientService.edit(patient);
		
		Assert.isTrue(patient.getId() == id, "Edit: " + patient.toString());
	}
	
	@Test
	public void deletePatientById() throws Exception
	{
		int id = data.number().numberBetween(1, 31);
		patientService.delete(id);
		
		Patient patient = patientService.findById(id);
		Assert.isTrue(patient == null, "Delete: Paciente no existe");
		
	}
}
