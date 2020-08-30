package com.csandoval.consultorio.rol.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.rol.domain.Rol;
import com.csandoval.consultorio.rol.repository.IRoleRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

@Service
public class RoleServiceImpl extends CrudImpl<Rol, Integer> implements IRoleService
{

	@Autowired
	private IRoleRepository roleRepository;
	
	@Override
	protected IGenericRepository<Rol, Integer> getRepository()
	{
		// TODO Auto-generated method stub
		return roleRepository;
	}

}
