package com.me.common.mapper;

import org.mapstruct.Mapping;

import com.me.common.dto.OrderDto;
import com.me.common.entity.Order;

public interface OrderMapper {

	@Mapping(target = "customer", ignore = true)
	Order dtoToEntity(OrderDto order);
	
	@Mapping(target = "customer", ignore = true)
	OrderDto entityToDto(Order order);
}
