package com.me.webservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.me.common.entity.ImageStorage;
import com.me.common.enums.ImageEnum;
import com.me.common.exceptions.CustomException;

public interface ImageStorageService {

	ImageStorage save(MultipartFile image, ImageEnum imageEnum) throws CustomException;
	
	Boolean deleteById(Long id) throws CustomException;

}
