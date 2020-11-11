package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vn.entity.Book;
import com.vn.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productPage() {
		ModelAndView m = new ModelAndView("productListPage");
		
		List<Book> list = bookService.getAllBooks();

		m.addObject("books", list);
		return m;
	}

}
