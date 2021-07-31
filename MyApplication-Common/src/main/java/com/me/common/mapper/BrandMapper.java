package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.BrandDto;
import com.me.common.entity.Brand;

@Component
public class BrandMapper {

	public BrandDto entityToDto(Brand brand) {
		JMapper<BrandDto, Brand> mapper = new JMapper<>(BrandDto.class, Brand.class);
		return mapper.getDestination(brand);
	}

	public Brand dtoToEntity(BrandDto brand) {
		JMapper<Brand, BrandDto> mapper = new JMapper<>(Brand.class, BrandDto.class);
		return mapper.getDestination(brand);
	}
}
