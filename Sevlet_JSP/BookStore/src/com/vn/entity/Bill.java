package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the bill database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private double totalCash;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional one-to-one association to Order
	@OneToOne
	@JoinColumn(name = "Order_ID", referencedColumnName = "ID")
	private Order order;

}