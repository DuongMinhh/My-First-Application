package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.BalanceDto;
import com.me.common.entity.Balance;

@Component
public class BalanceMapper {
	
	@Autowired
	private ModelMapper mapper;

	Balance dtoToEntity(BalanceDto balance) {
		return mapper.map(balance, Balance.class);
	}

	BalanceDto entityToDto(Balance balance) {
		return mapper.map(balance, BalanceDto.class);
	}
}
