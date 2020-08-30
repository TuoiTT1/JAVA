package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 760670554899843542L;

	private Integer ID;
	private String Title;
	private Integer Year;
	private Float price;
	private Author author;
	private Publisher publisher;

	public Book() {
	}

	public Book(Integer iD, String title, Integer year, Float price, Author author, Publisher publisher) {
		super();
		ID = iD;
		Title = title;
		Year = year;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

}
