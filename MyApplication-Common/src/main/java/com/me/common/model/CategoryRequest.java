package com.me.common.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

	@NotNull
	private Long id;
	
	@Size(max = 100, message = "Name max size is 100")
	private String name;
	
	@Size(max = 256, message = "Description max size is 256")
	private String description;
	
	private Long parentCategoryId;
}
