package com.csandoval.consultorio.user.application;

import com.csandoval.consultorio.user.domain.Usuario;
import com.csandoval.consultorio.web.application.ICrud;

public interface IUsuarioService extends ICrud<Usuario, Integer>
{
	Usuario findByUsername(String username);
}
