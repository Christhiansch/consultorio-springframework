package com.csandoval.consultorio.user.infraestructure.repository;

import com.csandoval.consultorio.user.domain.Usuario;
import com.csandoval.consultorio.web.infraestructure.repository.IGenericRepository;

public interface IUsuarioRepository extends IGenericRepository<Usuario, Integer>
{

	Usuario findByUsername(String username);
}
