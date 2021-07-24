package com.me.common.mapper;

import org.mapstruct.Mapper;

import com.me.common.dto.ImageStorageDto;
import com.me.common.entity.ImageStorage;

@Mapper(componentModel = "spring")
public interface ImageStorageMapper {

	ImageStorage dtoToEntity(ImageStorageDto imageStorage);
	
	ImageStorageDto entityToDto(ImageStorage imageStorage);
}
