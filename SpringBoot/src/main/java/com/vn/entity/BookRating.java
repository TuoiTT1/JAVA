package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the bookrating database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "BookRating.findAll", query = "SELECT b FROM BookRating b")
public class BookRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int rating;

	// bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

}