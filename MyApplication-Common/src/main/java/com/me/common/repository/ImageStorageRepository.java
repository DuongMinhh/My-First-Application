package com.me.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.common.entity.ImageStorage;

@Repository
public interface ImageStorageRepository extends JpaRepository<ImageStorage, Long> {

}
