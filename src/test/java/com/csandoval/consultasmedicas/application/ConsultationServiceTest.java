package com.csandoval.consultasmedicas.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.csandoval.consultorio.consultation.application.service.IConsultationService;
import com.csandoval.consultorio.consultation.domain.Consultation;
import com.csandoval.consultorio.consultation.domain.DetailConsultation;
import com.csandoval.consultorio.doctor.application.IDoctorService;
import com.csandoval.consultorio.doctor.domain.Doctor;
import com.csandoval.consultorio.patient.application.IPatientService;
import com.csandoval.consultorio.patient.domain.Patient;
import com.github.javafaker.Faker;

@SpringBootTest
public class ConsultationServiceTest
{

	private Faker data = new Faker();	
	
	@Autowired
	private IConsultationService consultationService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceTest.class);
	
	@Test
	public void createConsultation()
	{
		LocalDateTime consultationDate = LocalDateTime.now();
		
		try
		{
			int doctor_id = data.number().numberBetween(1, doctorService.listAll().size());
			Doctor doctor = doctorService.findById(doctor_id);
			
			int patient_id = data.number().numberBetween(1, patientService.listAll().size());
			Patient patient = patientService.findById(patient_id);
			
			List<DetailConsultation> details = new ArrayList<>();
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			details.add(new DetailConsultation(data.food().ingredient(), data.food().measurement()));
			
			Consultation consultation = consultationService.registerDetailConsultation(new Consultation(consultationDate, doctor, patient, details));
			
			assertTrue(consultation != null, "Se registro la consulta y sus detalles de la consulta");
			
			LOGGER.info("SUCCES CREATE CONSULTATION & DETAIL CONSULTATION");
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		
	}
	
	@Test
	public void listConsultations()
	{
		
	}
	
	@Test
	public void editConsultation()
	{
		
	}
	
	@Test
	public void deleteConsultation()
	{
		
	}
	
}
