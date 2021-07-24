package com.me.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;
	
	private List<ImageStorageDto> listImageStorage;
	
	private Long brandId;
	
	private BrandDto brand;
	
	@Size(max = 256, message = "Description max size is 256")
	private String description;
	
	private Long categoryId;
	
	private CategoryDto category;
	
	private Double price;
	
	private Float discount;
	
	private Boolean isActive;
	
	private Long sellerId;
	
	private SellerDto seller;
	
}
