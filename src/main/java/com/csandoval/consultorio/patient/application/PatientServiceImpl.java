package com.csandoval.consultorio.patient.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.crud.application.CrudImpl;
import com.csandoval.consultorio.crud.repository.IGenericRepository;
import com.csandoval.consultorio.patient.domain.Patient;
import com.csandoval.consultorio.patient.infraestructure.repository.IPatientRepository;


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
