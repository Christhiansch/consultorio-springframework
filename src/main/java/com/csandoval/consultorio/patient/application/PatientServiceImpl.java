package com.csandoval.consultorio.patient.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.patient.domain.Patient;
import com.csandoval.consultorio.patient.infraestructure.repository.IPatientRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;


@Service
public class PatientServiceImpl extends CrudImpl<Patient, Integer> implements IPatientService
{

	@Autowired
	private IPatientRepository patientRepository;
	
	@Override
	protected IGenericRepository<Patient, Integer> getRepository()
	{
		return patientRepository;
	}

}
