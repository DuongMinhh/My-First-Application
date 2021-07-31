package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.SellerDto;
import com.me.common.entity.Seller;

@Component
public class SellerMapper {

	@Autowired
	private ModelMapper mapper;

	public SellerDto entiyToDto(Seller obj) {
		TypeMap<Seller, SellerDto> typeMap = mapper.addMappings(new PropertyMap<Seller, SellerDto>() {
			@Override
			protected void configure() {
				skip().setBalance(null);
				skip().setUserInformation(null);
				map(source.getBalanceId(), destination.getBalanceId());
				map(source.getUserInformationId(), destination.getUserInformationId());
				map(source.getListProduct(), destination.getListProduct());
			}
		});
		return typeMap.map(obj);
	}

	public Seller dtoToEntity(SellerDto obj) {
		TypeMap<SellerDto, Seller> typeMap = mapper.addMappings(new PropertyMap<SellerDto, Seller>() {
			@Override
			protected void configure() {
				skip().setBalance(null);
				skip().setUserInformation(null);
				map(source.getBalanceId(), destination.getBalanceId());
				map(source.getUserInformationId(), destination.getUserInformationId());
				map(source.getListProduct(), destination.getListProduct());
			}
		});
		return typeMap.map(obj);
	}
	
}
