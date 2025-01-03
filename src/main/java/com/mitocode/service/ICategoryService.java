package com.mitocode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Category;

public interface ICategoryService extends ICRUD<Category, Integer>{
		
	
	//List<Category> searchByName(String name);
	
	List<Category> searchByNameLike(String name);
	
	//paginacion
	Page<Category> findAllPagination(Pageable page);
}
