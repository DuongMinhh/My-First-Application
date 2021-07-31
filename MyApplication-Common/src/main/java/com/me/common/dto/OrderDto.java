package com.me.common.dto;

import java.io.Serializable;

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
public class OrderDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Long id;

	@JMap
	private Long customerId;

	private CustomerDto customer;

	@JMap
	private Boolean isPaid;

}
