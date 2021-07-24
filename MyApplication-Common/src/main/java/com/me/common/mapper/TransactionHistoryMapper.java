package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.TransactionHistoryDto;
import com.me.common.entity.TransactionHistory;

@Mapper(componentModel = "spring")
public interface TransactionHistoryMapper {

	@Mapping(target = "customer", ignore = true)
	@Mapping(target = "seller", ignore = true)
	@Mapping(target = "orderDetails", ignore = true)
	TransactionHistory dtoToEntity(TransactionHistoryDto transactionHistory);
	
	@Mapping(target = "customer", ignore = true)
	@Mapping(target = "seller", ignore = true)
	@Mapping(target = "orderDetails", ignore = true)
	TransactionHistoryDto entityToDto(TransactionHistory transactionHistory);
}
