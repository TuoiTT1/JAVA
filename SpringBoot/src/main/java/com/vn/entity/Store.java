package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The persistent class for the store database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String reasonUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	// bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

}