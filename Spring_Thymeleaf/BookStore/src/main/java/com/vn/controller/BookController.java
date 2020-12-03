package com.vn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("content", "layout/home");
		return "index";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productPage(Model model) {

		List<Book> list = bookService.getAllBooks();

		System.out.println(list.get(0));
		model.addAttribute("books", list);
		model.addAttribute("content", "layout/book_list");
		return "index";
	}

	@GetMapping("/product/new")
	public String formCreate(Model model) {
		Book book = new Book();

		model.addAttribute("book", book);
		model.addAttribute("content", "layout/add_book");
		return "index";
	}

	@GetMapping("/product/edit/{id}")
	public String formEdit(@PathVariable int id, Model model) {

		Book book = bookService.getById(id);

		model.addAttribute("book", book);
		model.addAttribute("content", "layout/add_book");
		return "index";
	}

	@PostMapping("/product/save")
	public String saveProduct(@ModelAttribute("book") Book book, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		book.setIsDeleted((byte) 0);
		bookService.save(book);
		return "redirect:/products";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		bookService.delete(id);
		return "redirect:/products";
	}

}
