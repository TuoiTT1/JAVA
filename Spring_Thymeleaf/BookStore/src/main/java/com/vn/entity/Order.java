package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the order database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isBill;

	// bi-directional one-to-one association to Cart
	@OneToOne
	@JoinColumn(name = "Cart_ID", referencedColumnName = "ID")
	private Cart cart;

	// bi-directional one-to-one association to Bill
	@OneToOne(mappedBy = "order")
	private Bill bill;

	// bi-directional one-to-one association to Shippinginfo
	@OneToOne
	@JoinColumn(name = "ShippingInfo_ID", referencedColumnName = "ID")
	private ShippingInfo shippinginfo;

}