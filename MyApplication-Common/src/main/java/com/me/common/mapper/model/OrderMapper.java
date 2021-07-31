package com.me.common.mapper.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.OrderDto;
import com.me.common.entity.Order;

@Component
public class OrderMapper {

	@Autowired
	private ModelMapper mapper;

	public OrderDto entiyToDto(Order obj) {
		TypeMap<Order, OrderDto> typeMap = mapper.addMappings(new PropertyMap<Order, OrderDto>() {
			@Override
			protected void configure() {
				skip().setCustomer(null);
				map(source.getCustomerId(), destination.getCustomerId());
			}
		});

		return typeMap.map(obj);
	}
	
	public Order entiyToDto(OrderDto obj) {
		TypeMap<OrderDto, Order> typeMap = mapper.addMappings(new PropertyMap<OrderDto, Order>() {
			@Override
			protected void configure() {
				skip().setCustomer(null);
				map(source.getCustomerId(), destination.getCustomerId());
			}
		});

		return typeMap.map(obj);
	}
	
}
