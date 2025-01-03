package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.mitocode.model.Sale;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISaleRepo;
import com.mitocode.service.ISaleService;

public class SaleServiceImpl extends CRUDImpl<Sale, Integer> implements ISaleService {
	
	@Autowired
	private ISaleRepo repo;

	@Override
	protected IGenericRepo<Sale, Integer> getRepo() {
		return repo;
	}
}
