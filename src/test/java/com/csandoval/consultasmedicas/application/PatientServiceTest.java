package com.csandoval.consultasmedicas.application;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.csandoval.consultasmedicas.domain.Patient;
import com.github.javafaker.Faker;

@SpringBootTest
@ContextConfiguration
public class PatientServiceTest
{

	@Autowired
	private IPatientService patientService;
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(PatientServiceTest.class);
	
	@Test
	public void createPatient() throws Exception
	{
		
		Faker data = new Faker();
		
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
}
