package com.csandoval.consultorio.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csandoval.consultorio.user.domain.User;
import com.csandoval.consultorio.user.infraestructure.repository.IUserRepository;
import com.csandoval.consultorio.web.application.CrudImpl;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

@Service
public class UserServiceImpl extends CrudImpl<User, Integer> implements IUserService
{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	protected IGenericRepository<User, Integer> getRepository()
	{
		return userRepository;
	}

	@Override
	public User findByUsername(String username)
	{
		
		return userRepository.findByUsername(username);
	}

}
