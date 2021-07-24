package com.me.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class SellerDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 100, message = "Name max size is 100")
	private String name;

	@Size(max = 2048, message = "Introduction size is 2048")
	private String introduction;

	@Size(max = 256, message = "Address max size is 256")
	private String address;

	@Size(max = 100, message = "Email max size is 100")
	private String email;

	@Size(max = 20, message = "Phone number max size is 20")
	private String phoneNumber;

	@Size(min = 6, max = 20, message = "The size of password have to between 6 - 20 characters")
	@NotBlank(message = "Password is not blank")
	private String password;

	private List<ProductDto> listProduct;

	private Long balanceId;

	private BalanceDto balance;

	private Integer roleId;

	private RoleDto role;
}
