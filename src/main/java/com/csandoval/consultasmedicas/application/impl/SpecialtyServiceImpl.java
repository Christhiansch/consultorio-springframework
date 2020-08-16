package com.csandoval.consultasmedicas.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultasmedicas.application.ISpecialtyService;
import com.csandoval.consultasmedicas.domain.Specialty;
import com.csandoval.consultasmedicas.repository.IGenericRepository;
import com.csandoval.consultasmedicas.repository.ISpecialtyRepository;

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
