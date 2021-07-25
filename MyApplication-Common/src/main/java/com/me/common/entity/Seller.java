package com.me.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "seller", schema = "public")
public class Seller extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;
	
	@Column(name = "introduction", columnDefinition = "varchar(2048)")
	private String introduction;
	
	@Column(name = "address", columnDefinition = "varchar(256)")
	private String address;
	
	@Column(name = "user_information_id")
	private Long userInformationId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_information_id", insertable = false, updatable = false)
	private UserInformation userInformation;
	
	@OneToMany(mappedBy = "seller")
	private List<Product> listProduct;

	@Column(name = "balance_id")
	private Long balanceId;
	
	@OneToOne
	@JoinColumn(name = "balance_id", insertable = false, updatable = false)
	private Balance balance;
	
}