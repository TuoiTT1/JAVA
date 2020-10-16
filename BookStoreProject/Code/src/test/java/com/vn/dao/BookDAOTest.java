
package com.vn.dao;

import com.vn.dao.impl.BookDAOImpl;
import com.vn.entity.Book;
import com.vn.entity.Category;

import junit.framework.TestCase;

public class BookDAOTest extends TestCase {

	static BookDAO bookDAO = new BookDAOImpl();
	
	public void testCreate() {
		Book bookSearch;
		Book book = new Book();
		book.setName("Tôi thấy hoa vàng trên cỏ xanh");
		book.setAuthor("Nguyễn Nhật Ánh");
		book.setQuantity(10);
		
		Category category = new Category();
		category.setId(1);
		book.setCategory(category);
		
		book = bookDAO.create(book);
		System.out.println(book);
		
		bookSearch = bookDAO.findById(book.getId());
		System.out.println(bookSearch);
		
		assertEquals(book.getId(), bookSearch.getId());
		
	}
}
