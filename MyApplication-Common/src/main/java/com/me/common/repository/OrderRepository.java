package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
