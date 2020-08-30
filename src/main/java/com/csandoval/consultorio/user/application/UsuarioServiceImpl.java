package com.csandoval.consultorio.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.user.domain.Usuario;
import com.csandoval.consultorio.user.infraestructure.repository.IUsuarioRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

@Service
public class UsuarioServiceImpl extends CrudImpl<Usuario, Integer> implements IUsuarioService
{

	@Autowired
	private IUsuarioRepository userRepository;
	
	@Override
	protected IGenericRepository<Usuario, Integer> getRepository()
	{
		return userRepository;
	}

	@Override
	public Usuario findByUsername(String username)
	{
		
		return userRepository.findByUsername(username);
	}

}
