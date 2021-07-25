package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.CategoryDto;
import com.me.common.entity.Category;
import com.me.common.model.CategoryRequest;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mapping(target = "parentCategory", ignore = true)
	CategoryDto entityToDto(Category category);
	
	@Mapping(target = "parentCategory", ignore = true)
	Category dtoToEntity(CategoryDto category);
	
	@Mapping(target = "parentCategory", ignore = true)
	Category modelToEntity(CategoryRequest category);
}
