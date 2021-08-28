package com.me.common.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	private LocalDateTime timestamp;
	private HttpStatus code;
	private String message;
	
	public CustomException(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
}
