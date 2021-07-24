package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
