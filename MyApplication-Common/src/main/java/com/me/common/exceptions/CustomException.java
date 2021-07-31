package com.me.common.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus code;
	private String message;
	private LocalDateTime timestamp;
	
	public CustomException(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
}
