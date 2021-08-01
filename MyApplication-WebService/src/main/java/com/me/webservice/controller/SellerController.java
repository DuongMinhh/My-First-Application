package com.me.webservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.common.exceptions.CustomException;
import com.me.common.model.BasicResponse;
import com.me.common.model.SellerRegisterRequest;
import com.me.webservice.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody SellerRegisterRequest req) {
		try {
			return ResponseEntity.ok(sellerService.register(req));
		} catch (CustomException e) {
			return new ResponseEntity<>(new BasicResponse(e.getCode(), e.getMessage()), e.getCode());
		}
	}
}
