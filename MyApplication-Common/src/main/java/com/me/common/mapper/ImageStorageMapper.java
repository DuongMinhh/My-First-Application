package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.ImageStorageDto;
import com.me.common.entity.ImageStorage;

@Component
public class ImageStorageMapper {

	public ImageStorage dtoToEntity(ImageStorageDto imageStorage) {
		JMapper<ImageStorage, ImageStorageDto> mapper = new JMapper<>(ImageStorage.class, ImageStorageDto.class);
		return mapper.getDestination(imageStorage);
	}

	public ImageStorageDto entityToDto(ImageStorage imageStorage) {
		JMapper<ImageStorageDto, ImageStorage> mapper = new JMapper<>(ImageStorageDto.class, ImageStorage.class);
		return mapper.getDestination(imageStorage);
	}

}
