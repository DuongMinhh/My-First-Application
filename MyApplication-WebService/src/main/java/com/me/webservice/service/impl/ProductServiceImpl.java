package com.me.webservice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.ProductDto;
import com.me.common.entity.ImageStorage;
import com.me.common.entity.Product;
import com.me.common.enums.ImageEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.ProductMapper;
import com.me.common.repository.ProductRepository;
import com.me.webservice.service.ImageStorageService;
import com.me.webservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ImageStorageService imageStorageService;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public ProductDto save(ProductDto product) throws CustomException {
		try {
			Product entity = productMapper.dtoToEntity(product);
			entity.setId(null);
			entity.setIsActive(false);
			return productMapper.entityToDto(productRepository.save(entity));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Transactional
	@Override
	public ProductDto addImage(Long id, List<MultipartFile> images) throws CustomException {
		try {
			Product entity = productRepository.getById(id);
			List<ImageStorage> listImageStorage = new ArrayList<ImageStorage>();

			images.forEach(img -> {
				try {
					listImageStorage.add(imageStorageService.save(img, ImageEnum.PRODUCT));
				} catch (CustomException e) {
					log.error(e.getMessage());
				}
			});
			listImageStorage.addAll(entity.getListImageStorage());
			entity.setListImageStorage(listImageStorage);
			return productMapper.entityToDto(productRepository.save(entity));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public ProductDto update(ProductDto product) throws CustomException {
		try {
			Product entity = productRepository.getById(product.getId());
			entity.setName(product.getName());
			entity.setBrandId(product.getBrandId());
			entity.setDescription(product.getDescription());
			entity.setCategoryId(product.getCategoryId());
			entity.setPrice(product.getPrice());
			entity.setDiscount(product.getDiscount());
			entity.setIsActive(product.getIsActive());

			return productMapper.entityToDto(productRepository.save(entity));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public Boolean deleteById(Long id) throws CustomException {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public Boolean deleteImage(Long productId, Long imageId) throws CustomException {
		try {
			Product entity = productRepository.getById(productId);
			entity.getListImageStorage().removeIf(i -> i.getId() == imageId);
			productRepository.save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public ProductDto getById(Long id) throws CustomException {
		try {
			Product entity = productRepository.findById(id).orElseGet(() -> new Product());
			return productMapper.entityToDto(entity);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<ProductDto> getBySeller(Long sellerId) throws CustomException {
		try {
			List<Product> listProduct = productRepository.findBySellerId(sellerId)
					.orElseGet(() -> Collections.emptyList());
			return listProduct.stream().map(productMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<ProductDto> getByBrand(Long brandId) throws CustomException {
		try {
			List<Product> listProduct = productRepository.findByBrandId(brandId)
					.orElseGet(() -> Collections.emptyList());
			return listProduct.stream().map(productMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<ProductDto> getByCategory(Long categoryId) throws CustomException {
		try {
			List<Product> listProduct = productRepository.findByCategoryId(categoryId)
					.orElseGet(() -> Collections.emptyList());
			return listProduct.stream().map(productMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<ProductDto> searchProduct(String key) throws CustomException {
		try {
			List<Product> listProduct = productRepository.searchProduct(key)
					.orElseGet(() -> Collections.emptyList());
			return listProduct.stream().map(productMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<ProductDto> getAll() throws CustomException {
		try {
			List<Product> listProduct = productRepository.findAll();
			return listProduct.stream().map(productMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

}
