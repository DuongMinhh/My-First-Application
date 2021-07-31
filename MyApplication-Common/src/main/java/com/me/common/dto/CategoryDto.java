package com.me.common.dto;

import java.io.Serializable;

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
public class CategoryDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

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
	
	private CategoryDto parentCategory;
	
}
