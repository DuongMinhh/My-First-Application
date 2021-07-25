package com.me.webservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.common.model.LoginRequest;
import com.me.common.model.LoginResponse;
import com.me.webservice.config.security.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		try {

			Authentication rawAuthenObject = new UsernamePasswordAuthenticationToken(loginRequest.getLoginInfo(),
					loginRequest.getPassword());
			Authentication resultAuthenObject = authenticationManager.authenticate(rawAuthenObject);

			String jwtToken = jwtUtil.generateJwt(resultAuthenObject.getPrincipal().toString());
			List<String> roles = resultAuthenObject.getAuthorities().stream().map(i -> i.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new LoginResponse(jwtToken, resultAuthenObject.getName(), roles));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/logout")
	public ResponseEntity<LoginResponse> logout() {
		try {
			return ResponseEntity.ok(new LoginResponse());
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
}
