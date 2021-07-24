package com.me.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "public")
public class Product extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;
	
	@OneToMany
	@JoinTable(name = "product_image", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "image_storage_id")})
	private List<ImageStorage> listImageStorage;
	
	@Column(name = "brand_id")
	private Long brandId;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", insertable = false, updatable = false)
	private Brand brand;
	
	@Column(name = "description", columnDefinition = "varchar(256)")
	private String description;
	
	@Column(name = "category_id")
	private Long categoryId;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "discount")
	private Float discount;
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private Boolean isActive;
	
	@Column(name = "seller_id")
	private Long sellerId;
	
	@ManyToOne
	@JoinColumn(name = "seller_id", insertable = false, updatable = false)
	private Seller seller;
	
}
