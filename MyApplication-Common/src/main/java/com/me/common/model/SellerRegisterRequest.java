package com.me.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.googlecode.jmapper.annotations.JMap;
import com.me.common.exceptions.CustomMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerRegisterRequest {

	@NotBlank
	private String name;
	private String address;
	private String introduction;
	
	@JMap
	@NotBlank
	@Size(min = 6, max = 20, message = CustomMessage.FIELD_LEN_INVALID)
	private String username;
	
	@JMap
	@Pattern(regexp = CustomMessage.EMAIL_REGEX, message = CustomMessage.EMAIL_INVALID)
	private String email;
	
	@JMap
	@Pattern(regexp = CustomMessage.PHONE_REGEX, message = CustomMessage.PHONE_INVALID)
	private String phoneNumber;
	
	@JMap
	@Size(min = 6, max = 20, message = CustomMessage.FIELD_LEN_INVALID)
	private String password;
	
}
