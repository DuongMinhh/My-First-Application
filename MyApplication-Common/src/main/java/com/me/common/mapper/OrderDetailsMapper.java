package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.OrderDetailsDto;
import com.me.common.entity.OrderDetails;

@Component
public class OrderDetailsMapper {

	public OrderDetailsDto entiyToDto(OrderDetails obj) {
		JMapper<OrderDetailsDto, OrderDetails> mapper = new JMapper<>(OrderDetailsDto.class, OrderDetails.class);
		return mapper.getDestination(obj);
	}

	public OrderDetails dtoToEntity(OrderDetailsDto obj) {
		JMapper<OrderDetails, OrderDetailsDto> mapper = new JMapper<>(OrderDetails.class, OrderDetailsDto.class);
		return mapper.getDestination(obj);
	}

}
