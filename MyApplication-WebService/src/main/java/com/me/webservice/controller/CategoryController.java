package com.me.webservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.model.BasicResponse;
import com.me.common.model.CategoryRequest;
import com.me.webservice.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getRootNodes() {
		try {
			return new ResponseEntity<>(categoryService.getNodes(), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
	@GetMapping("/{id}/sub-categories")
	public ResponseEntity<?> getByNodeId(@PathVariable("id") Long categoryId) {
		try {
			return new ResponseEntity<>(categoryService.getByNodeId(categoryId), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long categoryId) {
		try {
			return new ResponseEntity<>(categoryService.getById(categoryId), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody CategoryRequest categoryRequest) {
		try {
			return new ResponseEntity<>(categoryService.create(categoryRequest), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody CategoryRequest categoryRequest) {
		try {
			return new ResponseEntity<>(categoryService.update(categoryRequest), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long categoryId) {
		try {
			categoryService.deleteById(categoryId);
			return new ResponseEntity<>(CustomMessage.ACTION_SUCCESS, HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
	
}
