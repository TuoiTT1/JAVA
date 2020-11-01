package com.vn.dao;

import java.util.List;

import com.vn.entity.Category;

public interface CategoryDAO {

	public Category create(Category category);

	public Category update(Category category);

	public List<Category> getAll();

	public Category findById(int id);

	public Integer delete(int id);
}
