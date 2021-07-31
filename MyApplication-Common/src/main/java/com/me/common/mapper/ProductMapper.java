package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.ProductDto;
import com.me.common.entity.Product;

@Component
public class ProductMapper {

	public ProductDto entiyToDto(Product obj) {
		JMapper<ProductDto, Product> mapper = new JMapper<>(ProductDto.class, Product.class);
		return mapper.getDestination(obj);
	}
	
	public Product dtoToEntity(ProductDto obj) {
		JMapper<Product, ProductDto> mapper = new JMapper<>(Product.class, ProductDto.class);
		return mapper.getDestination(obj);
	}
	
}
