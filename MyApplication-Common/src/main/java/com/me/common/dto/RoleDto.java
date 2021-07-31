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
public class RoleDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Integer id;

	@JMap
	@Size(max = 30, message = "Name max size is 30")
	private String name;
}
