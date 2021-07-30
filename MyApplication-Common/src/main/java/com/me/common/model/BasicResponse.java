package com.me.common.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasicResponse {

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	private LocalDateTime timestamp;
	
	private HttpStatus status;
	
	private String message;

	public BasicResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
}
