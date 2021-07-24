package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.BrandDto;
import com.me.common.entity.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {

	@Mapping(target = "imageStorage", ignore = true)
	BrandDto entityToDto(Brand brand);
	
	@Mapping(target = "imageStorage", ignore = true)
	Brand dtoToEntity(BrandDto brand);
}
