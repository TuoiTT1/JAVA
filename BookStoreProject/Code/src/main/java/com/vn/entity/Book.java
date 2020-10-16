package com.vn.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the book database table.
 * 
 */
@Setter
@Getter
@Entity
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String author;

	private String description;

	private String imageURL;

	private byte isDeleted;

	private String name;

	private float price;

	private String publisher;

	private int quantity;

	private int yearOfPublication;

	// bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	// bi-directional many-to-one association to Bookorder
	@OneToMany(mappedBy = "book")
	private List<BookOrder> bookorders;

	// bi-directional many-to-one association to Bookrating
	@OneToMany(mappedBy = "book")
	private List<BookRating> bookratings;

	// bi-directional many-to-one association to Booksale
	@OneToMany(mappedBy = "book")
	private List<BookSale> booksales;

	// bi-directional many-to-one association to Store
	@OneToMany(mappedBy = "book")
	private List<Store> stores;

	public BookRating addBookrating(BookRating bookrating) {
		getBookratings().add(bookrating);
		bookrating.setBook(this);

		return bookrating;
	}

	public BookRating removeBookrating(BookRating bookrating) {
		getBookratings().remove(bookrating);
		bookrating.setBook(null);

		return bookrating;
	}

	public BookSale addBooksale(BookSale booksale) {
		getBooksales().add(booksale);
		booksale.setBook(this);

		return booksale;
	}

	public BookSale removeBooksale(BookSale booksale) {
		getBooksales().remove(booksale);
		booksale.setBook(null);

		return booksale;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setBook(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setBook(null);

		return store;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", description=" + description + ", imageURL=" + imageURL
				+ ", isDeleted=" + isDeleted + ", name=" + name + ", price=" + price + ", publisher=" + publisher
				+ ", quantity=" + quantity + ", yearOfPublication=" + yearOfPublication + "]";
	}

}