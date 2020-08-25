package com.csandoval.consultorio.web.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, V> extends JpaRepository<T, V>
{

}
