package com.mitocode.service.impl;

import java.util.List;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	//
	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T create(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> readAll() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T readById(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public T update(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public void delete(ID id) throws Exception {
		getRepo().deleteById(id);
		
	}
	
	
	
}
