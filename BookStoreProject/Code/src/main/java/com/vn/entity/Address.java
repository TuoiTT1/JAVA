package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the address database table.
 * 
 */
@Getter
@Setter
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String city;

	private String distric;

	private String num;

	private String ward;

	// bi-directional one-to-one association to Account
	@OneToOne(mappedBy = "address")
	private Account account;

	// bi-directional one-to-one association to Shippinginfo
	@OneToOne(mappedBy = "address")
	private ShippingInfo shippinginfo;

}