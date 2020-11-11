package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the bookorder database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b")
public class BookOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int quantity;

	// bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	// bi-directional many-to-one association to Cart
	@ManyToOne
	private Cart cart;

}