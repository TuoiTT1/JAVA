package com.vn.dao;

import java.util.ArrayList;
import java.util.List;

import com.vn.entity.Category;
import com.vn.impl.CategoryDAOImpl;

import junit.framework.TestCase;

public class CategoryDAOTest extends TestCase {

	static CategoryDAO categoryDAO = new CategoryDAOImpl();

	public void testCreate() {
		Category category = new Category();
		Category searchCategory;
		category.setTitle("Văn học");

		category = categoryDAO.create(category);
		System.out.println(category);

		searchCategory = categoryDAO.findById(category.getId());
		System.out.println(searchCategory);

		assertEquals(category, searchCategory);
	}

	public void testUpdate() {
		Category category = new Category();
		category.setId(2);
		Category searchCategory;
		category.setTitle("Truyện ngắn");

		category = categoryDAO.update(category);
		System.out.println(category);

		searchCategory = categoryDAO.findById(2);
		System.out.println(searchCategory);

		assertEquals(category, searchCategory);
	}
	
	public void testDelete() {
		assertEquals(1, categoryDAO.delete(8).intValue());
		assertEquals(-1, categoryDAO.delete(9).intValue());
	}
	
	public void testGetAll() {
		List<Category> list = new ArrayList<Category>();
		list = categoryDAO.getAll();
		
		for (Category category : list) {
			System.out.println(category);
		}
		
		assertEquals(3, list.size());
	}
}
