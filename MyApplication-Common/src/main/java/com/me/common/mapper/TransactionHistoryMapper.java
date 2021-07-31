package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.TransactionHistoryDto;
import com.me.common.entity.TransactionHistory;

@Component
public class TransactionHistoryMapper {

	@Autowired
	private ModelMapper mapper;

	public TransactionHistoryDto entiyToDto(TransactionHistory obj) {
		TypeMap<TransactionHistory, TransactionHistoryDto> typeMap = mapper.addMappings(new PropertyMap<TransactionHistory, TransactionHistoryDto>() {
			@Override
			protected void configure() {
				skip().setCustomer(null);
				skip().setSeller(null);
				skip().setOrderDetails(null);
				map(source.getCustomerId(), destination.getCustomerId());
				map(source.getSellerId(), destination.getSellerId());
				map(source.getOrderDetailId(), destination.getOrderDetailId());
			}
		});
		return typeMap.map(obj);
	}
	
	public TransactionHistory dtoToEntity(TransactionHistoryDto obj) {
		TypeMap<TransactionHistoryDto, TransactionHistory> typeMap = mapper.addMappings(new PropertyMap<TransactionHistoryDto, TransactionHistory>() {
			@Override
			protected void configure() {
				skip().setCustomer(null);
				skip().setSeller(null);
				skip().setOrderDetails(null);
				map(source.getCustomerId(), destination.getCustomerId());
				map(source.getSellerId(), destination.getSellerId());
				map(source.getOrderDetailId(), destination.getOrderDetailId());
			}
		});
		return typeMap.map(obj);
	}
	
}
