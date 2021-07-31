package com.me.common.dto;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;
import com.me.common.entity.Order;

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
public class OrderDetailsDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Long id;
	
	@JMap
	private Long orderId;
	
	private Order order;
	
	@JMap
	private Long productId;
	
	private ProductDto product;
	
}
