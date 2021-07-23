package com.me.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seller", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "phone_number"}))
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
	
	@Column(name = "email", columnDefinition = "varchar(100)")
	private String email;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "password", columnDefinition = "varchar(20)", nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "seller")
	private List<Product> listProduct;

	@Column(name = "balance_id")
	private Long balanceId;
	
	@OneToOne
	@JoinColumn(name = "balance_id", insertable = false, updatable = false)
	private Balance balance;
	
}