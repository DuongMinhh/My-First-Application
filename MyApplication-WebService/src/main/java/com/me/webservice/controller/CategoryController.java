package com.me.webservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.common.dto.CategoryDto;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.model.CategoryRequest;
import com.me.webservice.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/category")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getRootNodes() {
		try {
			return ResponseEntity.ok(categoryService.getNodes());
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@GetMapping("/{id}/sub-categories")
	public ResponseEntity<List<CategoryDto>> getByNodeId(@PathVariable("id") Long categoryId) {
		try {
			return ResponseEntity.ok(categoryService.getByNodeId(categoryId));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getById(@PathVariable("id") Long categoryId) {
		try {
			return ResponseEntity.ok(categoryService.getById(categoryId));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryRequest categoryRequest) {
		try {
			return ResponseEntity.ok(categoryService.create(categoryRequest));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PutMapping
	public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryRequest categoryRequest) {
		try {
			return ResponseEntity.ok(categoryService.update(categoryRequest));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long categoryId) {
		try {
			categoryService.deleteById(categoryId);
			return ResponseEntity.ok(CustomMessage.ACTION_SUCCESS);
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
}
