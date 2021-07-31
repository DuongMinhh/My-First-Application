package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.CustomerDto;
import com.me.common.entity.Customer;

@Component
public class CustomerMapper {

	@Autowired
	private ModelMapper mapper;

	public CustomerDto entiyToDto(Customer customer) {
		TypeMap<Customer, CustomerDto> typeMap = mapper.addMappings(new PropertyMap<Customer, CustomerDto>() {
			@Override
			protected void configure() {
				skip().setBalance(null);
				skip().setUserInformation(null);
				map(source.getBalanceId(), destination.getBalanceId());
				map(source.getUserInformationId(), destination.getUserInformationId());

			}
		});
		return typeMap.map(customer);
	}

	public Customer dtoToEntity(CustomerDto customer) {
		TypeMap<CustomerDto, Customer> typeMap = mapper.addMappings(new PropertyMap<CustomerDto, Customer>() {
			@Override
			protected void configure() {
				skip().setBalance(null);
				skip().setUserInformation(null);
				map(source.getBalanceId(), destination.getBalanceId());
				map(source.getUserInformationId(), destination.getUserInformationId());

			}
		});
		return typeMap.map(customer);
	}

}
