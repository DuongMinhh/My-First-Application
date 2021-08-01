package com.me.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand", schema = "public")
public class Brand extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "brand_image", joinColumns = { @JoinColumn(name = "brand_id") }, inverseJoinColumns = {
			@JoinColumn(name = "image_storage_id") })
	private List<ImageStorage> listImageStorage;

	@Column(name = "introduction", columnDefinition = "varchar(2048)")
	private String introduction;

}
