package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
