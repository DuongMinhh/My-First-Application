package com.me.common.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus code;
	private String message;
	
	public CustomException(HttpStatus code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
}
