package com.vn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/product/new")
	public ModelAndView formCreate() {
		ModelAndView m = new ModelAndView("detailProductPage");

		return m;
	}

	@GetMapping("/product/edit/{id}")
	public ModelAndView formEdit(@PathVariable int id) {
		ModelAndView m = new ModelAndView("detailProductPage");

		Book book = bookService.getById(id);

		m.addObject("book", book);
		return m;
	}

	@PostMapping("/product/save")
	public void saveProduct(@ModelAttribute("book") Book book, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		bookService.save(book);
		response.sendRedirect(request.getContextPath() + "/products");
	}

	@GetMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable int id, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		bookService.delete(id);
		response.sendRedirect(request.getContextPath() + "/products");
	}

}
