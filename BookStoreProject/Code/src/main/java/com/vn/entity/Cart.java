package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the cart database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to Bookorder
	@OneToMany(mappedBy = "cart")
	private List<BookOrder> bookorders;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	// bi-directional one-to-one association to Order
	@OneToOne(mappedBy = "cart")
	private Order order;

	public BookOrder addBookorder(BookOrder bookorder) {
		getBookorders().add(bookorder);
		bookorder.setCart(this);

		return bookorder;
	}

	public BookOrder removeBookorder(BookOrder bookorder) {
		getBookorders().remove(bookorder);
		bookorder.setCart(null);

		return bookorder;
	}

}