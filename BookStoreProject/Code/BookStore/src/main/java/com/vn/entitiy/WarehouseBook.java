package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class WarehouseBook implements Serializable {

	private static final long serialVersionUID = 6326063947828699203L;

	private Integer id;
	private Book book;
	private Warehouse warehouse;
	private Integer count;

	public WarehouseBook() {
	}

	public WarehouseBook(Integer id, Book book, Warehouse warehouse, Integer count) {
		super();
		this.id = id;
		this.book = book;
		this.warehouse = warehouse;
		this.count = count;
	}

}
