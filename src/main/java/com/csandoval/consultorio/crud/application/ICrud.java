package com.csandoval.consultorio.crud.application;

import java.util.List;

public interface ICrud<T, V>
{

	T create(T entity) throws Exception;

	T edit(T entity) throws Exception;

	List<T> listAll() throws Exception;

	T findById(V id) throws Exception;

	void delete(V id) throws Exception;
}
