package com.csandoval.consultasmedicas.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultasmedicas.application.IPatientService;
import com.csandoval.consultasmedicas.domain.Patient;
import com.csandoval.consultasmedicas.repository.IGenericRepository;
import com.csandoval.consultasmedicas.repository.IPatientRepository;

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
