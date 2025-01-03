package com.mitocode.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mitocode.model.Category;
import com.mitocode.repo.ICategoryRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICategoryService;

@Service
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {
	
	@Autowired
	private ICategoryRepo repo;

	@Override
	protected IGenericRepo<Category, Integer> getRepo() {
		return repo;
	}

	
	/*
	 * SELECT * FROM Category WHERE name LIKE %?%
	@Override
	public List<Category> searchByNameLike(String name) {
		return repo.findByNameLike("%"+name+"%");
	}
	*/

	/*
	//SELCT * FROM Category WHERE name = ? AND enabled ?
	@Override
	public List<Category> searchByNameLike(String name) {		
		return repo.findByNameLikeAndEnabled("%"+name+"%", true);
	}
	*/
	
	@Override
	public List<Category> searchByNameLike(String name) {	
		return repo.searchByStatus(true);
	}


	@Override
	public Page<Category> findAllPagination(Pageable page) {
		
		return repo.findAll(page);
	}
	
	/*
    @Override
	public List<Category> searchByStatusSQL(String name) {		
		return repo.searchByStatusSQL(true);
	}
	 * 
	 * */
		
}
