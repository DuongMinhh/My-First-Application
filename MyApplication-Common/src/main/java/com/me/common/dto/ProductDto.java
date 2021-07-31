package com.me.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JMap
	private Long id;

	@JMap
	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;

	@JMap
	private List<ImageStorageDto> listImageStorage;

	@JMap
	private Long brandId;

	private BrandDto brand;

	@JMap
	@Size(max = 256, message = "Description max size is 256")
	private String description;

	@JMap
	private Long categoryId;

	private CategoryDto category;

	@JMap
	private Double price;

	@JMap
	private Float discount;

	@JMap
	private Boolean isActive;

	@JMap
	private Long sellerId;

	private SellerDto seller;

}
