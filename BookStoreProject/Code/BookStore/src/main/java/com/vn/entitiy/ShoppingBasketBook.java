package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingBasketBook implements Serializable {

	private static final long serialVersionUID = -1813127290225314224L;

	private Integer id;
	private Book book;
	private User user;
	private Integer count;

	public ShoppingBasketBook() {
	}

	public ShoppingBasketBook(Integer id, Book book, User user, Integer count) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.count = count;
	}

}
