package com.csandoval.consultorio.user.infraestructure.repository;

import com.csandoval.consultorio.user.domain.User;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

public interface IUserRepository extends IGenericRepository<User, Integer>
{

	User findByUsername(String username);
}
