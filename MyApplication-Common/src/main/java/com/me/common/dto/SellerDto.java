package com.me.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private Long userInformationId;

	private UserInformationDto userInformation;

	private List<ProductDto> listProduct;

	private Long balanceId;

	private BalanceDto balance;

}