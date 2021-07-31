package com.me.common.model;

import javax.validation.constraints.Size;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

	@JMap
	private Long id;
	
	@JMap
	@Size(max = 100, message = "Name max size is 100")
	private String name;
	
	@JMap
	@Size(max = 256, message = "Description max size is 256")
	private String description;
	
	@JMap
	private Long parentCategoryId;
}
