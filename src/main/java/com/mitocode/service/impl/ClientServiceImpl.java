package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;



import com.mitocode.model.Client;
import com.mitocode.repo.IClientRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IClienteService;

public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClienteService {
	
	@Autowired
	private IClientRepo repo;

	@Override
	protected IGenericRepo<Client, Integer> getRepo() {
		return repo;
	}
}
