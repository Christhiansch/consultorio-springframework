package com.csandoval.consultorio.specialty.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.specialty.domain.Specialty;
import com.csandoval.consultorio.specialty.infraestructure.repository.ISpecialtyRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

@Service
public class SpecialtyServiceImpl extends CrudImpl<Specialty, Integer> implements ISpecialtyService
{

	@Autowired
	private ISpecialtyRepository specialtyRepository;
	
	@Override
	protected IGenericRepository<Specialty, Integer> getRepository()
	{
		return specialtyRepository;
	}

}
