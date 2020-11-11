package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the shippinginfo database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "ShippingInfo.findAll", query = "SELECT s FROM ShippingInfo s")
public class ShippingInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String phone;

	private String receiver;

	// bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name = "Address_ID", referencedColumnName = "ID")
	private Address address;

	// bi-directional one-to-one association to Order
	@OneToOne(mappedBy = "shippinginfo")
	private Order order;

}