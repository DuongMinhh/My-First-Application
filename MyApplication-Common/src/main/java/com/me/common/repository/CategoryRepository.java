package com.me.common.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<List<Category>> findByParentCategoryIdIsNull();
	
	Optional<List<Category>> findByParentCategoryId(Long categoryId);
}
