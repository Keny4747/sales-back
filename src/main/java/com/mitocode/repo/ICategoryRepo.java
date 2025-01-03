package com.mitocode.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Category;

public interface ICategoryRepo extends IGenericRepo<Category, Integer>{
	
	//Búsque de coincidencia (exactitud)
	//SELECT * FROM Category WHERE name = ?
	List<Category> findByName(String name);
	
	//SELECT * FROM Category WHERE name LIKE %?%
	//List<Category> findByNameLike(String name);
	
	//SELCT * FROM Category WHERE name = ? AND enabled ?
	List<Category> findByNameLikeAndEnabled(String name, boolean enabled); 
	
	//Named Query
	@Query("FROM Category c Where c.enabled = : status")
	List<Category> searchByStatus(@Param("status")boolean status);
	
	//Native Query
	@Query(value = "SELECT * FROM category c WHERE c.enabled = :status", nativeQuery = true)
	List<Category> searchByStatusSQL(@Param("status")boolean status);
}
