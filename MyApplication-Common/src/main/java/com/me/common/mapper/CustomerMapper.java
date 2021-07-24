package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.CustomerDto;
import com.me.common.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	@Mapping(target = "balance", ignore = true)
	@Mapping(target = "role", ignore = true)
	Customer dtoToEntity(CustomerDto customer);

	@Mapping(target = "balance", ignore = true)
	@Mapping(target = "role", ignore = true)
	CustomerDto entityToDto(Customer customer);
}
