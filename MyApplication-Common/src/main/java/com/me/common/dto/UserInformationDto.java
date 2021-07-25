package com.me.common.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
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
public class UserInformationDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	@Size(max = 100, message = "Email max size is 100")
	private String email;
	
	@Size(max = 20, message = "Phone number max size is 20")
	private String phoneNumber;
	
	@Size(min = 6, max = 20, message = "The size of password have to between 6 - 20 characters")
	@NotBlank(message = "Password is not blank")
	private String password;
	
	private Integer roleId;
	
	private RoleDto role;
	
	private Boolean isEnable;
	
}
