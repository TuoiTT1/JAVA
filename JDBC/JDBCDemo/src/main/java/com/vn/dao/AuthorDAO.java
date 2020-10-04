package com.vn.dao;

import java.util.List;

import com.vn.entity.Author;

public interface AuthorDAO {

	public int delete(int id);

	public int create(Author author);

	public int update(Author author);

	public List<Author> getll();

	public Author findById(int id);

}
