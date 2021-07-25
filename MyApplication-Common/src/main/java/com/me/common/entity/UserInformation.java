package com.me.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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
@Table(name = "user_information", schema = "public")
public class UserInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String username;

	@Column(name = "email", columnDefinition = "varchar(100)", nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
	private String password;
	
	@Column(name = "role_id", nullable = false)
	private Integer roleId;
	
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@Column(name = "is_enable", columnDefinition = "boolean default true", nullable = false)
	private Boolean isEnable;
	
	@PrePersist
	public void prePersist() {
		this.isEnable = true;
	}
	
}
