package com.csandoval.consultasmedicas.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultasmedicas.application.IDoctorService;
import com.csandoval.consultasmedicas.domain.Doctor;
import com.csandoval.consultasmedicas.repository.IDoctorRepository;
import com.csandoval.consultasmedicas.repository.IGenericRepository;

@Service
public class DoctorServiceImpl extends CrudImpl<Doctor, Integer> implements IDoctorService
{

	@Autowired
	private IDoctorRepository doctorRepository;

	@Override
	protected IGenericRepository<Doctor, Integer> getRepository()
	{
		return doctorRepository;
	}

}
