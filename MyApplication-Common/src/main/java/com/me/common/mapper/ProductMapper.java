package com.me.common.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.CollectionUtils;

import com.me.common.dto.ImageStorageDto;
import com.me.common.dto.ProductDto;
import com.me.common.entity.ImageStorage;
import com.me.common.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper extends ImageStorageMapper {

	@Mapping(target = "brand", ignore = true)
	@Mapping(target = "category", ignore = true)
	@Mapping(target = "seller", ignore = true)
	Product dtoToEntity(ProductDto product);
	
	@Mapping(target = "brand", ignore = true)
	@Mapping(target = "category", ignore = true)
	@Mapping(target = "seller", ignore = true)
	ProductDto entityToDto(Product product);
	
//	default List<ImageStorage> listImageStorageDtoToEntity(List<ImageStorageDto> listImageStorage) {
//		try {
//			if (CollectionUtils.isEmpty(listImageStorage)) {
//				return Collections.emptyList();
//			} else {
//				return listImageStorage.stream().map(this::dtoToEntity).collect(Collectors.toList());
//			}
//		} catch (Exception e) {
//			return Collections.emptyList();
//		}
//	}
//	
//	default List<ImageStorageDto> listImageStorageEntityToDto(List<ImageStorage> listImageStorage) {
//		try {
//			if (CollectionUtils.isEmpty(listImageStorage)) {
//				return Collections.emptyList();
//			} else {
//				return listImageStorage.stream().map(this::entityToDto).collect(Collectors.toList());
//			}
//		} catch (Exception e) {
//			return Collections.emptyList();
//		}
//	}
}
