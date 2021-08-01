package com.me.common.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<List<Product>> findByCategoryId(Long categoryId);
	
	Optional<List<Product>> findBySellerId(Long sellerId);
	
	Optional<List<Product>> findByBrandId(Long brandId);

	@Query("	SELECT p FROM Product p "
			+ "	WHERE p.name LIKE %:key% "
			+ "		OR p.seller.name LIKE %:key% "
			+ "		OR p.brand.name LIKE %:key% "
			+ "		OR p.category.name LIKE %:key%")
	Optional<List<Product>> searchProduct(@Param("key") String key);	// By product name, seller name, brand name, category name, 
}
