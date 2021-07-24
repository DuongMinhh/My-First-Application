package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
