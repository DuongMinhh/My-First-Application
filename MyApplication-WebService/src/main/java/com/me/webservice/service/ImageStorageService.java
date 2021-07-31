package com.me.webservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.ImageStorageDto;
import com.me.common.enums.ImageEnum;
import com.me.common.exceptions.CustomException;

public interface ImageStorageService {

	ImageStorageDto save(MultipartFile image, ImageEnum imageEnum) throws CustomException;

}
