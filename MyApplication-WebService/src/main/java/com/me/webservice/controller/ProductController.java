package com.me.webservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.ProductDto;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.model.BasicResponse;
import com.me.webservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody ProductDto dto) {
		try {
			return ResponseEntity.ok(productService.save(dto));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@PutMapping(value = "/{id}/add-images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> addImage(@PathVariable("id") Long productId,
			@RequestPart("images") List<MultipartFile> images) {
		try {
			return ResponseEntity.ok(productService.addImage(productId, images));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody ProductDto dto) {
		try {
			return ResponseEntity.ok(productService.update(dto));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		try {
			productService.deleteById(id);
			return ResponseEntity.ok(new BasicResponse(HttpStatus.OK, CustomMessage.ACTION_SUCCESS));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@DeleteMapping("/{id}/delete-image/{imageId}")
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long productId, @PathVariable("imageId") Long imageId) {
		try {
			productService.deleteImage(productId, imageId);
			return ResponseEntity.ok(new BasicResponse(HttpStatus.OK, CustomMessage.ACTION_SUCCESS));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(productService.getById(id));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/by-seller/{sellerId}")
	public ResponseEntity<?> getBySeller(@PathVariable("sellerId") Long sellerId) {
		try {
			return ResponseEntity.ok(productService.getBySeller(sellerId));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/by-brand/{brandId}")
	public ResponseEntity<?> getByBrand(@PathVariable("brandId") Long brandId) {
		try {
			return ResponseEntity.ok(productService.getByBrand(brandId));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/by-category/{categoryId}")
	public ResponseEntity<?> getByCategory(@PathVariable("categoryId") Long categoryId) {
		try {
			return ResponseEntity.ok(productService.getByCategory(categoryId));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> getByCategory(@PathParam("key") String key) {
		try {
			return ResponseEntity.ok(productService.searchProduct(key));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(productService.getAll());
		} catch (CustomException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
	
}
