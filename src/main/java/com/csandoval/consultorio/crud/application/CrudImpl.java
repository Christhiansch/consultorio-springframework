package com.csandoval.consultorio.crud.application;

import java.util.List;

import com.csandoval.consultorio.crud.repository.IGenericRepository;

public abstract class CrudImpl<T, V> implements ICrud<T, V>
{
	protected abstract IGenericRepository<T, V> getRepository();

	@Override
	public T create(T entity) throws Exception
	{
		return getRepository().save(entity);
	}

	@Override
	public T edit(T entity) throws Exception
	{
		return getRepository().save(entity);
	}

	@Override
	public List<T> listAll() throws Exception
	{
		return getRepository().findAll();
	}

	@Override
	public T findById(V id) throws Exception
	{
		return getRepository().findById(id).orElse(null);
	}

	@Override
	public void delete(V id) throws Exception
	{
		getRepository().deleteById(id);
	}

}
