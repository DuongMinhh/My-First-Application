package com.me.common.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

	@NotBlank(message = "Login info is not blank")
	private String loginInfo;
	@NotBlank(message = "Password is not blank")
	private String password;
}
