package com.me.webservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.me.common.dto.BrandDto;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.model.BasicResponse;
import com.me.webservice.service.BrandService;

@CrossOrigin
@RestController
@RequestMapping("/brand")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public ResponseEntity<List<BrandDto>> getAll() {
		try {
			return ResponseEntity.ok(brandService.getAll());
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}

	@PostMapping
	public ResponseEntity<BrandDto> save(@Valid @RequestBody BrandDto brand) {
		try {
			return ResponseEntity.ok(brandService.save(brand));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PutMapping
	public ResponseEntity<BrandDto> Update(@Valid @RequestBody BrandDto brand) {
		try {
			return ResponseEntity.ok(brandService.update(brand));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BrandDto> getById(@PathVariable("id") Long brandId) {
		try {
			return ResponseEntity.ok(brandService.getById(brandId));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long brandId) {
		try {
			brandService.deleteById(brandId);
			return ResponseEntity.ok(new BasicResponse(HttpStatus.OK, CustomMessage.ACTION_SUCCESS));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	

	@PutMapping(value = "/{id}/add-images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<BrandDto> addImage(@PathVariable("id") Long brandId,
			@RequestPart("images") List<MultipartFile> images) {
		try {
			return ResponseEntity.ok(brandService.addImage(brandId, images));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@DeleteMapping("/{id}/delete-image/{imageId}")
	public ResponseEntity deleteImage(@PathVariable("id") Long brandId, @PathVariable("imageId") Long imageId) {
		try {
			brandService.deleteImage(brandId, imageId);
			return ResponseEntity.ok(new BasicResponse(HttpStatus.OK, CustomMessage.ACTION_SUCCESS));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}

}
