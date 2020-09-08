package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Book;

public interface BookDAO {

	public Integer delete(int id);

	public Book create(Book book);

	public Book update(Book book);

	public List<Book> getAll();

	public Book findById(int id);

}
