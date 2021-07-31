package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.OrderDto;
import com.me.common.entity.Order;

@Component
public class OrderMapper {

	public OrderDto entiyToDto(Order obj) {
		JMapper<OrderDto, Order> mapper = new JMapper<>(OrderDto.class, Order.class);
		return mapper.getDestination(obj);
	}

	public Order dtoToEntity(OrderDto obj) {
		JMapper<Order, OrderDto> mapper = new JMapper<>(Order.class, OrderDto.class);
		return mapper.getDestination(obj);
	}

}
