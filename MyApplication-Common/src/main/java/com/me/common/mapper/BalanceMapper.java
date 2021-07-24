package com.me.common.mapper;

import org.mapstruct.Mapper;

import com.me.common.dto.BalanceDto;
import com.me.common.entity.Balance;

@Mapper(componentModel = "spring")
public interface BalanceMapper {

	BalanceDto entityToDto(Balance balance);
	
	Balance dtoToEntity(BalanceDto balance);
}
