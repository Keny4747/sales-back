package com.mitocode.service.impl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mitocode.model.Ingress;

import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IIngressRepo;

import com.mitocode.service.IIngresService;

@Service
public class IngressServiceImpl extends CRUDImpl<Ingress, Integer> implements IIngresService {
	
	@Autowired
	private IIngressRepo repo;

	@Override
	protected IGenericRepo<Ingress, Integer> getRepo() {
		return repo;
	}
		

}
