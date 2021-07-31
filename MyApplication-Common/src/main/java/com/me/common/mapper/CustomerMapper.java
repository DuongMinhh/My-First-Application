package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.CustomerDto;
import com.me.common.entity.Customer;

@Component
public class CustomerMapper {

	public CustomerDto entiyToDto(Customer customer) {
		JMapper<CustomerDto, Customer> mapper = new JMapper<>(CustomerDto.class, Customer.class);
		return mapper.getDestination(customer);
	}

	public Customer dtoToEntity(CustomerDto customer) {
		JMapper<Customer, CustomerDto> mapper = new JMapper<>(Customer.class, CustomerDto.class);
		return mapper.getDestination(customer);
	}

}
