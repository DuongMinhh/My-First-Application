package com.me.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image_storage", schema = "public")
public class ImageStorage extends BaseEntity implements Serializable, Comparable<ImageStorage> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "local_path", columnDefinition = "varchar(256)")
	private String localPath;
	
	@Column(name = "image_name", columnDefinition = "varchar(256)")
	private String imageName;

	@Override
	public int compareTo(ImageStorage o) {
		return (int) (this.id - o.getId());
	}
}
