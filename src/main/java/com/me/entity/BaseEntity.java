package com.me.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
	
	@Column(name = "created_date", columnDefinition = "TIMESTAMP", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime createdDate;
	
	@Column(name = "updated_date", columnDefinition = "TIMESTAMP", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
	LocalDateTime updatedDate;
	
	@PrePersist
	public void prePersit() {
		this.createdDate = LocalDateTime.now();
		this.updatedDate = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedDate = LocalDateTime.now();
	}
	
}
