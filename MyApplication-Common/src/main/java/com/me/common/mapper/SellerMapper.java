package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.SellerDto;
import com.me.common.entity.Seller;

@Component
public class SellerMapper {

	public SellerDto entiyToDto(Seller obj) {
		JMapper<SellerDto, Seller> mapper = new JMapper<>(SellerDto.class, Seller.class);
		return mapper.getDestination(obj);
	}

	public Seller dtoToEntity(SellerDto obj) {
		JMapper<Seller, SellerDto> mapper = new JMapper<>(Seller.class, SellerDto.class);
		return mapper.getDestination(obj);
	}
	
}
