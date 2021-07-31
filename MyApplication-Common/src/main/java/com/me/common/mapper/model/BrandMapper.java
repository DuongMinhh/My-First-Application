package com.me.common.mapper.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.BrandDto;
import com.me.common.entity.Brand;

@Component
public class BrandMapper {

	@Autowired
	private ModelMapper mapper;

	public BrandDto entiyToDto(Brand brand) {
		TypeMap<Brand, BrandDto> typeMap = mapper.addMappings(new PropertyMap<Brand, BrandDto>() {
			@Override
			protected void configure() {
				skip().setImageStorage(null);
				map(source.getImageStorageId(), destination.getImageStorageId());
			}
		});

		return typeMap.map(brand);
	}

	public Brand dtoToEntiy(BrandDto brand) {
		TypeMap<BrandDto, Brand> typeMap = mapper.addMappings(new PropertyMap<BrandDto, Brand>() {
			@Override
			protected void configure() {
				skip().setImageStorage(null);
				map(source.getImageStorageId(), destination.getImageStorageId());
			}
		});

		return typeMap.map(brand);
	}
}
