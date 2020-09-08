package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Author;

public interface AuthorDAO {

	public Integer delete(int id);

	public Author create(Author author);

	public Author update(Author author);

	public List<Author> getAll();

	public Author findById(int id);

}
