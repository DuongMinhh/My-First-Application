package com.me.webservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.BrandDto;
import com.me.common.exceptions.CustomException;

public interface BrandService {

	BrandDto save(BrandDto brand) throws CustomException;
	
	BrandDto addImage(Long brandId, List<MultipartFile> images) throws CustomException;
	
	BrandDto update(BrandDto brand) throws CustomException;
	
	BrandDto getById(Long id) throws CustomException;
	
	List<BrandDto> getAll() throws CustomException;
	
	Boolean deleteById(Long id) throws CustomException;
	
	Boolean deleteImage(Long brandId, Long imageId) throws CustomException;
}
