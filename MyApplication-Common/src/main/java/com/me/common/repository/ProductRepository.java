package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
