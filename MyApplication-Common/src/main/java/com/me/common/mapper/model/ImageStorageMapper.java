package com.me.common.mapper.model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.ImageStorageDto;
import com.me.common.entity.ImageStorage;

@Component
public class ImageStorageMapper {

	@Autowired
	private ModelMapper mapper;

	ImageStorage dtoToEntity(ImageStorageDto imageStorage) {
		return mapper.map(imageStorage, ImageStorage.class);
	}

	ImageStorageDto entityToDto(ImageStorage imageStorage) {
		return mapper.map(imageStorage, ImageStorageDto.class);
	}
	
}
