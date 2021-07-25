package com.me.common.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

	@NotBlank(message = "Phone or email is not blank")
	private String phoneOrEmail;
	@NotBlank(message = "Password is not blank")
	private String password;
}
