package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.model.Provider;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IProviderRepo;
import com.mitocode.service.IProviderService;

public class ProviderServiceImpl extends CRUDImpl<Provider, Integer> implements IProviderService {
	
	@Autowired
	private IProviderRepo repo;

	@Override
	protected IGenericRepo<Provider, Integer> getRepo() {
		return repo;
	}
}
