package com.csandoval.consultorio.doctor.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.doctor.domain.Doctor;
import com.csandoval.consultorio.doctor.infraestructure.repository.IDoctorRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

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
