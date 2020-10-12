package com.vn.dao;

import java.util.List;

import com.vn.entity.Book;

public interface BookDAO {

	public Book create(Book book);

	public Book update(Book book);

	public List<Book> getAll();

	public Book findById(int id);

	public Integer delete(int id);
}
