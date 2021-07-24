package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
