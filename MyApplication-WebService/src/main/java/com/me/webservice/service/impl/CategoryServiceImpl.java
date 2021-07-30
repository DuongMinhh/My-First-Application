package com.me.webservice.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.me.common.dto.CategoryDto;
import com.me.common.entity.Category;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.CategoryMapper;
import com.me.common.model.CategoryRequest;
import com.me.common.repository.CategoryRepository;
import com.me.webservice.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDto> getNodes() throws CustomException {
		try {
			List<Category> listCategories = categoryRepo.findByParentCategoryIdIsNull()
					.orElseGet(() -> Collections.emptyList());
			return listCategories.stream().map(categoryMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<CategoryDto> getByNodeId(Long categoryId) throws CustomException {
		try {
			List<Category> listCategories = categoryRepo.findByParentCategoryId(categoryId)
					.orElseGet(() -> Collections.emptyList());
			return listCategories.stream().map(categoryMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public CategoryDto getById(Long categoryId) throws CustomException {
		try {
			Category category = categoryRepo.findById(categoryId).orElseGet(() -> new Category());
			return categoryMapper.entityToDto(category);
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	@Transactional
	public CategoryDto create(CategoryRequest categoryDto) throws CustomException {
		try {
			Category category = categoryMapper.modelToEntity(categoryDto);
			category.setId(-1L);
			return categoryMapper.entityToDto(categoryRepo.save(category));
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	@Transactional
	@Modifying
	public CategoryDto update(CategoryRequest categoryRequest) throws CustomException {
		try {
			Category categoryDb = categoryRepo.getById(categoryRequest.getId());
			if (categoryRequest.getName() != null) {
				categoryDb.setName(categoryRequest.getName());
			}
			if (categoryRequest.getDescription() != null) {
				categoryDb.setDescription(categoryRequest.getDescription());
			}
			if (categoryRequest.getParentCategoryId() != null) {
				categoryDb.setParentCategoryId(categoryRequest.getParentCategoryId());
			}
			return categoryMapper.entityToDto(categoryRepo.save(categoryDb));
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.RESOURCE_NOT_FOUND);
		}
	}

	@Override
	@Transactional
	@Modifying
	public Boolean deleteById(Long categoryId) throws CustomException {
		try {
			categoryRepo.deleteById(categoryId);
			return true;
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.RESOURCE_NOT_FOUND);
		}
	}
	
}
