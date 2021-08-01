package com.me.webservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.ProductDto;
import com.me.common.exceptions.CustomException;

public interface ProductService {

	ProductDto save(ProductDto product) throws CustomException;
	
	ProductDto addImage(Long id, List<MultipartFile> images) throws CustomException;
	
	ProductDto update(ProductDto product) throws CustomException;
	
	Boolean deleteById(Long id) throws CustomException;
	
	Boolean deleteImage(Long productId, Long imageId) throws CustomException;
	
	ProductDto getById(Long id) throws CustomException;
	
	List<ProductDto> getBySeller(Long sellerId) throws CustomException;
	
	List<ProductDto> getByBrand(Long brandId) throws CustomException;
	
	List<ProductDto> getByCategory(Long categoryId) throws CustomException;
	
	List<ProductDto> searchProduct(String key) throws CustomException;
	
	List<ProductDto> getAll() throws CustomException;
	
}
