package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.ProductDto;
import com.me.common.entity.Product;

@Component
public class ProductMapper {

	@Autowired
	private ModelMapper mapper;

	public ProductDto entiyToDto(Product obj) {
		TypeMap<Product, ProductDto> typeMap = mapper.addMappings(new PropertyMap<Product, ProductDto>() {
			@Override
			protected void configure() {
				skip().setBrand(null);
				skip().setCategory(null);
				skip().setSeller(null);
				map(source.getBrandId(), destination.getBrandId());
				map(source.getCategoryId(), destination.getCategoryId());
				map(source.getSellerId(), destination.getSellerId());
				map(source.getListImageStorage(), destination.getListImageStorage());
				
			}
		});
		return typeMap.map(obj);
	}
	
	public Product dtoToEntity(ProductDto obj) {
		TypeMap<ProductDto, Product> typeMap = mapper.addMappings(new PropertyMap<ProductDto, Product>() {
			@Override
			protected void configure() {
				skip().setBrand(null);
				skip().setCategory(null);
				skip().setSeller(null);
				map(source.getBrandId(), destination.getBrandId());
				map(source.getCategoryId(), destination.getCategoryId());
				map(source.getSellerId(), destination.getSellerId());
				map(source.getListImageStorage(), destination.getListImageStorage());
			}
		});
		return typeMap.map(obj);
	}
	
}
