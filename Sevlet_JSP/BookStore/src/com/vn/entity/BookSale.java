package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the booksale database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "BookSale.findAll", query = "SELECT b FROM BookSale b")
public class BookSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	// bi-directional many-to-one association to Sale
	@ManyToOne
	private Sale sale;

}