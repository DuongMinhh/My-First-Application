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
public class BalanceDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Double accountBalance;
}
