package com.me.webservice.service;

import java.util.List;

import com.me.common.dto.CategoryDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.CategoryRequest;

public interface CategoryService {

	List<CategoryDto> getNodes() throws CustomException;	// This mean is the node parent of category
	
	List<CategoryDto> getByNodeId(Long categoryId) throws CustomException;	// This mean is childs of node
	
	CategoryDto getById(Long categoryId) throws CustomException;
	
	CategoryDto create(CategoryRequest categoryRequest) throws CustomException;
	
	CategoryDto update(CategoryRequest categoryRequest) throws CustomException;
	
	Boolean deleteById(Long categoryId) throws CustomException;
	
}
