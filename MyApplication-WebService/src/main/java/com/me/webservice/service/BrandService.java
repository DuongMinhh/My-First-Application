package com.me.webservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.BrandDto;
import com.me.common.exceptions.CustomException;

public interface BrandService {

	BrandDto save(BrandDto brand, MultipartFile image) throws CustomException;
	
	BrandDto update(BrandDto brand) throws CustomException;
	
	BrandDto getById(Integer id) throws CustomException;
	
	List<BrandDto> getAll() throws CustomException;
	
	Boolean deleteById(Integer id) throws CustomException;
}
