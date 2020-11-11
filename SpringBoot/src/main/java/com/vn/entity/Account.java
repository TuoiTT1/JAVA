package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the account database table.
 * 
 */
@Getter
@Setter
@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private byte admin;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String firstName;

	private String lastName;

	private String password;

	private String phone;

	private String userName;

	// bi-directional one-to-one association to Customer
	@OneToOne(mappedBy = "account", fetch=FetchType.LAZY)
	private Customer customer;

	// bi-directional one-to-one association to Employee
	@OneToOne(mappedBy = "account", fetch=FetchType.LAZY)
	private Employee employee;

	// bi-directional one-to-one association to Address
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Address_ID", referencedColumnName = "ID")
	private Address address;

}