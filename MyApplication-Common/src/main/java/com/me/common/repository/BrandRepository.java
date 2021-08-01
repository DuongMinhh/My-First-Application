package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

	@Query(value = "DELETE FROM brand_image bi "
			+ "		WHERE bi.brand_id = :brandId "
			+ "		AND bi.image_storage_id = :imageId", nativeQuery = true)
	Boolean deleteImageByBrandIdAndImageId(@Param("brandId")Long brandId, @Param("imageId")Long imageId);
}
