package com.me.common.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.CollectionUtils;

import com.me.common.dto.ProductDto;
import com.me.common.dto.SellerDto;
import com.me.common.entity.Product;
import com.me.common.entity.Seller;

@Mapper(componentModel = "spring")
public interface SellerMapper extends ProductMapper {
	
	@Mapping(target = "balance", ignore = true)
	@Mapping(target = "userInformation", ignore = true)
	Seller dtoToEntity(SellerDto seller);
	
	@Mapping(target = "balance", ignore = true)
	@Mapping(target = "userInformation", ignore = true)
	SellerDto entityToDto(Seller seller);
	
	default List<Product> listProductDtoToEntity(List<ProductDto> listProduct) {
		try {
			if (CollectionUtils.isEmpty(listProduct)) {
				return Collections.emptyList();
			} else {
				return listProduct.stream().map(this::dtoToEntity).collect(Collectors.toList());
			}
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	default List<ProductDto> listProductEntityToDto(List<Product> listProduct) {
		try {
			if (CollectionUtils.isEmpty(listProduct)) {
				return Collections.emptyList();
			} else {
				return listProduct.stream().map(this::entityToDto).collect(Collectors.toList());
			}
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
}
