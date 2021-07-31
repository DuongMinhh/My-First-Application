package com.me.common.dto;

import java.io.Serializable;
import java.util.List;

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
public class SellerDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Long id;

	@JMap
	@Size(max = 100, message = "Name max size is 100")
	private String name;

	@JMap
	@Size(max = 2048, message = "Introduction size is 2048")
	private String introduction;

	@JMap
	@Size(max = 256, message = "Address max size is 256")
	private String address;

	@JMap
	private Long userInformationId;

	private UserInformationDto userInformation;

	@JMap
	private List<ProductDto> listProduct;

	@JMap
	private Long balanceId;

	private BalanceDto balance;

}
