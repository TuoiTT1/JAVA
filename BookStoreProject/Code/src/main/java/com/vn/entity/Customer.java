package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the customer database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int coin;

	// bi-directional one-to-one association to Account
	@OneToOne
	@JoinColumn(name = "Account_Email", referencedColumnName = "Email")
	private Account account;

	// bi-directional many-to-one association to Bookrating
	@OneToMany(mappedBy = "customer")
	private List<BookRating> bookratings;

	// bi-directional many-to-one association to Cart
	@OneToMany(mappedBy = "customer")
	private List<Cart> carts;

	public BookRating addBookrating(BookRating bookrating) {
		getBookratings().add(bookrating);
		bookrating.setCustomer(this);

		return bookrating;
	}

	public BookRating removeBookrating(BookRating bookrating) {
		getBookratings().remove(bookrating);
		bookrating.setCustomer(null);

		return bookrating;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setCustomer(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setCustomer(null);

		return cart;
	}

}