package com.csandoval.consultorio.user.application;

import com.csandoval.consultorio.user.domain.User;
import com.csandoval.consultorio.web.application.ICrud;

public interface IUserService extends ICrud<User, Integer>
{
	User findByUsername(String username);
}
