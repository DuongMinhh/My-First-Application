package com.me.common.dto;

import java.io.Serializable;

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
public class TransactionHistoryDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long customerId;
	
	private CustomerDto customer;
	
	private Long sellerId;
	
	private SellerDto seller;
	
	private Long orderDetailId;
	
	private OrderDetailsDto orderDetails;
	
}
