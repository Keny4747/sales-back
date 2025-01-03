package com.mitocode;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.dto.CategoryDTO;
import com.mitocode.model.Category;

@Configuration
public class MapperConfig {
	
	@Bean
	public ModelMapper modelMapeer() {
		
		ModelMapper mapper = new ModelMapper();
		TypeMap<CategoryDTO, Category> typeMap = mapper.createTypeMap(CategoryDTO.class, Category.class);
		typeMap.addMapping(CategoryDTO::getIdCategory, Category::setIdCategory);
		typeMap.addMapping(CategoryDTO::getName, Category::setName);
		typeMap.addMapping(CategoryDTO::getDescription, Category::setDescription);
		typeMap.addMapping(CategoryDTO::isEnabled, Category::setEnabled);

		return new ModelMapper();
	}
}
