package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.BalanceDto;
import com.me.common.entity.Balance;

@Component
public class BalanceMapper {
	
	Balance dtoToEntity(BalanceDto obj) {
		JMapper<Balance, BalanceDto> mapper = new JMapper<>(Balance.class, BalanceDto.class);
		return mapper.getDestination(obj);
	}

	BalanceDto entityToDto(Balance obj) {
		JMapper<BalanceDto, Balance> mapper = new JMapper<>(BalanceDto.class, Balance.class);
		return mapper.getDestination(obj);
	}
}
