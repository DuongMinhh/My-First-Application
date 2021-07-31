package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.TransactionHistoryDto;
import com.me.common.entity.TransactionHistory;

@Component
public class TransactionHistoryMapper {

	public TransactionHistoryDto entiyToDto(TransactionHistory obj) {
		JMapper<TransactionHistoryDto, TransactionHistory> mapper = new JMapper<>(TransactionHistoryDto.class, TransactionHistory.class);
		return mapper.getDestination(obj);
	}
	
	public TransactionHistory dtoToEntity(TransactionHistoryDto obj) {
		JMapper<TransactionHistory, TransactionHistoryDto> mapper = new JMapper<>(TransactionHistory.class, TransactionHistoryDto.class);
		return mapper.getDestination(obj);
	}
	
}
