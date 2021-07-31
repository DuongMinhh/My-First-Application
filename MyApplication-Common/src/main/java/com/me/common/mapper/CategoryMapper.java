package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.CategoryDto;
import com.me.common.entity.Category;
import com.me.common.model.CategoryRequest;

@Component
public class CategoryMapper {
	
	public CategoryDto entityToDto(Category category) {
		JMapper<CategoryDto, Category> mapper = new JMapper<>(CategoryDto.class, Category.class);
		return mapper.getDestination(category);
	}
	
	public Category dtoToEntity(CategoryDto category) {
		JMapper<Category, CategoryDto> mapper = new JMapper<>(Category.class, CategoryDto.class);
		return mapper.getDestination(category);
	}
	
	public Category modelToEntity(CategoryRequest category) {
		JMapper<Category, CategoryRequest> mapper = new JMapper<>(Category.class, CategoryRequest.class);
		return mapper.getDestination(category);
	}
	
}
