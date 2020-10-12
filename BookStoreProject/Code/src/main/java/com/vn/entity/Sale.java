package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sale database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private float discount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	// bi-directional many-to-one association to Booksale
	@OneToMany(mappedBy = "sale")
	private List<BookSale> booksales;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	public BookSale addBooksale(BookSale booksale) {
		getBooksales().add(booksale);
		booksale.setSale(this);

		return booksale;
	}

	public BookSale removeBooksale(BookSale booksale) {
		getBooksales().remove(booksale);
		booksale.setSale(null);

		return booksale;
	}

}