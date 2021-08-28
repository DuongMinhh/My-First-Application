package com.me.webservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.common.dto.AdminDto;
import com.me.common.dto.CustomerDto;
import com.me.common.dto.SellerDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.AdminRegisterRequest;
import com.me.common.model.CustomerRegisterRequest;
import com.me.common.model.LoginRequest;
import com.me.common.model.LoginResponse;
import com.me.common.model.SellerRegisterRequest;
import com.me.webservice.service.AuthenticateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/authenticate")
@CrossOrigin("*")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AuthenticateController {

	@Autowired
	private AuthenticateService authenticateService;

	@PostMapping("/register/admin")
	public ResponseEntity<AdminDto> register(@Valid @RequestBody AdminRegisterRequest req) {
		try {
			return ResponseEntity.ok(authenticateService.register(req));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PostMapping("/register/customer")
	public ResponseEntity<CustomerDto> register(@Valid @RequestBody CustomerRegisterRequest req) {
		try {
			return ResponseEntity.ok(authenticateService.register(req));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PostMapping("/register/seller")
	public ResponseEntity<SellerDto> register(@Valid @RequestBody SellerRegisterRequest req) {
		try {
			return ResponseEntity.ok(authenticateService.register(req));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		try {
			return ResponseEntity.ok(authenticateService.login(loginRequest));
		} catch (CustomException e) {
			return new ResponseEntity(e, e.getCode());
		}
	}

	@GetMapping("/logout")
	public ResponseEntity<LoginResponse> logout() {
		try {
			return ResponseEntity.ok(new LoginResponse());
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
}
