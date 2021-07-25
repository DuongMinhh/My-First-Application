package com.me.common.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "admin", schema = "public")
public class Admin extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", columnDefinition = "varchar(50)", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "varchar(50)", nullable = false)
	private String lastName;
	
	@Column(name = "address", columnDefinition = "varchar(256)")
	private String address;
	
	@Column(name = "user_information_id")
	private Long userInformationId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_information_id", insertable = false, updatable = false)
	private UserInformation userInformation;
	
}
