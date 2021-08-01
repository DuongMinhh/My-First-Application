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
import com.me.common.model.CustomerRegisterRequest;
import com.me.webservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody CustomerRegisterRequest req) {
		try {
			return ResponseEntity.ok(customerService.register(req));
		} catch (CustomException e) {
			return ResponseEntity.status(e.getCode()).body(new BasicResponse(e));
		}
	}
}
