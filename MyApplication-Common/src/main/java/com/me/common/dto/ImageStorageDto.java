package com.me.common.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

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
public class ImageStorageDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(max = 256, message = "Local path max size is 256")
	private String localPath;
}