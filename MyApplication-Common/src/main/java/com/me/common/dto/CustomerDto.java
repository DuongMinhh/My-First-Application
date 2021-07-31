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
public class CustomerDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Long id;

	@JMap
	@Size(max = 50, message = "First name max size is 50")
	private String firstName;

	@JMap
	@Size(max = 50, message = "Last name max size is 50")
	private String lastName;

	@JMap
	@Size(max = 256, message = "Address max size is 256")
	private String address;

	@JMap
	private Long userInformationId;

	private UserInformationDto userInformation;

	@JMap
	private Long balanceId;

	private BalanceDto balance;

}
