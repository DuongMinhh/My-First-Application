package com.me.common.dto;

import java.io.Serializable;

import javax.persistence.Id;
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
public class RoleDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Size(max = 30, message = "Name max size is 30")
	private String name;
}
