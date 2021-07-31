package com.me.common.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.me.common.exceptions.CustomException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicResponse {

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	private LocalDateTime timestamp;
	
	private HttpStatus code;
	
	private String message;
	
	public BasicResponse(CustomException e) {
		this.code = e.getCode();
		this.message = e.getMessage();
		this.timestamp = e.getTimestamp();
	}

	public BasicResponse(HttpStatus status, String message) {
		this.code = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
}
