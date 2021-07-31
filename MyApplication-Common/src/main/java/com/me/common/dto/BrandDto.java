package com.me.common.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JMap
	private Long id;
	
	@JMap
	@Size(max = 100, message = "Name max size is 50")
	private String name;
	
	@JMap
	private Long imageStorageId;
	
	private ImageStorageDto imageStorage;
	
	@JMap
	@Size(max = 2048, message = "Introduction size is 2048")
	private String introduction;
	
}
