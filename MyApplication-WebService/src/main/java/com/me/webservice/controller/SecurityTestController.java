package com.me.webservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class SecurityTestController {

	@GetMapping
	@PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER', 'ROLE_SELLER')")
	public ResponseEntity<String> getAll() {
		
		log.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		log.info(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
		log.info(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
		
		return ResponseEntity.ok("Controller ok!");
	}
}
