package com.me.common.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDto {

	@JMap
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime createdDate;
	
	@JMap
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime updatedDate;
	
}
