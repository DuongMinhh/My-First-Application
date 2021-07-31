package com.me.webservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.BrandDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.BasicResponse;
import com.me.webservice.service.BrandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping
	private ResponseEntity<?> save(@Valid @RequestBody BrandDto brand, @RequestParam("image") MultipartFile image) {
		try {
			return ResponseEntity.ok(brandService.save(brand, image));
		} catch (CustomException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(new BasicResponse(e), e.getCode());
		}
	}

}
