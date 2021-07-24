package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.CategoryDto;
import com.me.common.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mapping(target = "category", ignore = true)
	CategoryDto entityToDto(Category category);
	
	@Mapping(target = "category", ignore = true)
	Category dtoToEntity(CategoryDto category);
}
