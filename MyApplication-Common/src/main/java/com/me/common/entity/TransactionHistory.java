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
@Table(name = "transaction_history", schema = "public")
public class TransactionHistory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	private Customer customer;
	
	@Column(name = "seller_id")
	private Long sellerId;
	
	@ManyToOne
	@JoinColumn(name = "seller_id", insertable = false, updatable = false)
	private Seller seller;
	
	@Column(name = "order_detail_id")
	private Long orderDetailId;
	
	@OneToOne
	@JoinColumn(name = "order_detail_id", updatable = false, insertable = false)
	private OrderDetails orderDetails;
	
}
