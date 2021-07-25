package com.me.common.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {

	private String token;
	private final String type = "Bearer";
	private String phoneOrEmail;
	private List<String> roles;
	
	public LoginResponse(String token, String phoneOrEmail, List<String> roles) {
		super();
		this.token = token;
		this.phoneOrEmail = phoneOrEmail;
		this.roles = roles;
	}
	
}
