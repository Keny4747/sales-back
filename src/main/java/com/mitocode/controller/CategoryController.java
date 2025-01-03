package com.mitocode.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.CategoryDTO;
import com.mitocode.exceptions.ModeloNotFoundExcecption;
import com.mitocode.model.Category;
import com.mitocode.service.ICategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	private ICategoryService service;
 
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> readAll() throws Exception {
		/*
		ModelMapper mapper = new ModelMapper();

		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);*/

		// usando stream
		List<CategoryDTO> list = service.readAll().stream().map(c -> mapper.map(c, CategoryDTO.class))
				.collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception {
		/*// librearia para DTOs
		ModelMapper mapper = new ModelMapper();

		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);
		*/

		Category obj = service.readById(id);

		if (obj == null) {
			throw new ModeloNotFoundExcecption("ID NOT FOUND");
		}
		// obj=origen, CategoryDTO=destino
		CategoryDTO dto = mapper.map(obj, CategoryDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/search") public List<Category>
	 * searchByName(@RequestParam("name")String name)throws Exception{ return
	 * service.searchByNameLike(name); }
	 */

	@GetMapping("/search")
	public ResponseEntity<List<CategoryDTO>> searchByNameLike(@RequestParam("name") String name) throws Exception {
		/*// librearia para DTOs
		ModelMapper mapper = new ModelMapper();

		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);
		*/

		List<CategoryDTO> list = service.searchByNameLike(name).stream().map(c->mapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) throws Exception {

		/*ModelMapper mapper = new ModelMapper();

		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);
		*/

		Category cat = mapper.map(categoryDTO, Category.class);

		Category obj = service.create(cat);

		categoryDTO.setIdCategory(obj.getIdCategory());

		return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryDTO) throws Exception {
		
		Category c = service.readById(categoryDTO.getIdCategory());
		
		if(c == null) {
			throw new ModeloNotFoundExcecption("ID NOT FOUND");
		}
		/*
		ModelMapper mapper = new ModelMapper();

		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);*/
		
		Category cat = mapper.map(categoryDTO, Category.class);
		service.update(cat);
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<Page<Category>> findAllPagination(Pageable page){
		Page<Category> p = service.findAllPagination(page);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}

}