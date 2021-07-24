package com.me.common.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDto {

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime createdDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime updatedDate;
	
}
