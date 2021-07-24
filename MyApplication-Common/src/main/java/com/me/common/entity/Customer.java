package com.me.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.me.common.enums.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "phone_number"}))
public class Customer extends BaseEntity implements Serializable {

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
	
	@Column(name = "email", columnDefinition = "varchar(100)")
	private String email;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
	private String password;
	
	@Column(name = "balance_id")
	private Long balanceId;
	
	@OneToOne
	@JoinColumn(name = "balance_id", insertable = false, updatable = false)
	private Balance balance;
	
	@Column(name = "role_id", nullable = false)
	private Integer roleId;
	
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@PrePersist
	public void prePersist() {
		this.roleId = RoleEnum.ROLE_CUSTOMER.value;
	}

}
