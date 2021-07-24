package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.OrderDetailsDto;
import com.me.common.entity.OrderDetails;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {

	@Mapping(target = "order", ignore = true)
	@Mapping(target = "product", ignore = true)
	OrderDetails dtoToEntity(OrderDetailsDto orderDetails);
	
	@Mapping(target = "order", ignore = true)
	@Mapping(target = "product", ignore = true)
	OrderDetailsDto entityToDto(OrderDetails orderDetails);
}
