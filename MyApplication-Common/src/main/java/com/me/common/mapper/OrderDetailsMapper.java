package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.OrderDetailsDto;
import com.me.common.entity.OrderDetails;

@Component
public class OrderDetailsMapper {

	@Autowired
	private ModelMapper mapper;

	public OrderDetailsDto entiyToDto(OrderDetails obj) {
		TypeMap<OrderDetails, OrderDetailsDto> typeMap = mapper.addMappings(new PropertyMap<OrderDetails, OrderDetailsDto>() {
			@Override
			protected void configure() {
				skip().setOrder(null);
				skip().setProduct(null);
				map(source.getOrderId(), destination.getOrderId());
				map(source.getProductId(), destination.getProductId());
			}
		});
		return typeMap.map(obj);
	}

	public OrderDetails dtoToEntity(OrderDetailsDto obj) {
		TypeMap<OrderDetailsDto, OrderDetails> typeMap = mapper.addMappings(new PropertyMap<OrderDetailsDto, OrderDetails>() {
			@Override
			protected void configure() {
				skip().setOrder(null);
				skip().setProduct(null);
				map(source.getOrderId(), destination.getOrderId());
				map(source.getProductId(), destination.getProductId());
			}
		});
		return typeMap.map(obj);
	}

}
