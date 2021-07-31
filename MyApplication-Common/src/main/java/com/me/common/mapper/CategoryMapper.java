package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.CategoryDto;
import com.me.common.entity.Category;
import com.me.common.model.CategoryRequest;

@Component
public class CategoryMapper {
	
	@Autowired
	private ModelMapper mapper;

	public CategoryDto entiyToDto(Category category) {
		TypeMap<Category, CategoryDto> typeMap = mapper.addMappings(new PropertyMap<Category, CategoryDto>() {
			@Override
			protected void configure() {
				skip().setParentCategory(null);
				map(source.getParentCategoryId(), destination.getParentCategoryId());
			}
		});
		return typeMap.map(category);
	}
	
	public Category dtoToEntity(CategoryDto category) {
		TypeMap<CategoryDto, Category> typeMap = mapper.addMappings(new PropertyMap<CategoryDto, Category>() {
			@Override
			protected void configure() {
				skip().setParentCategory(null);
				map(source.getParentCategoryId(), destination.getParentCategoryId());
			}
		});
		return typeMap.map(category);
	}
	
	public Category modelToEntity(CategoryRequest category) {
		TypeMap<CategoryRequest, Category> typeMap = mapper.addMappings(new PropertyMap<CategoryRequest, Category>() {
			@Override
			protected void configure() {
				skip().setParentCategory(null);
				map(source.getParentCategoryId(), destination.getParentCategoryId());
			}
		});
		return typeMap.map(category);
	}
}
