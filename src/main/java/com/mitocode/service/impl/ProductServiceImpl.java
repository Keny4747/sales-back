package com.mitocode.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.Product;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IProductRepo;
import com.mitocode.service.IProductService;

@Service
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {
	
	@Autowired
	private IProductRepo repo;

	@Override
	protected IGenericRepo<Product, Integer> getRepo() {
		return repo;
	}
		

}
