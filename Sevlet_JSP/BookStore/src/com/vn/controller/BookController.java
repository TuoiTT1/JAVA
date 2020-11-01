package com.vn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.dao.BookDAO;
import com.vn.dao.CategoryDAO;
import com.vn.dao.impl.BookDAOImpl;
import com.vn.dao.impl.CategoryDAOImpl;
import com.vn.entity.Book;
import com.vn.entity.Category;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static private BookDAO bookDAO = new BookDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action;
		String code;
		Book book = null;

		action = request.getParameter("action");

		if (action == null) {
			action = "";
		}
		switch (action) {
		case "create":

			request.getRequestDispatcher("/book/book_edit.jsp").forward(request, response);

			break;
		case "edit":
			code = request.getParameter("code");
			book = bookDAO.findById(Integer.valueOf(code));
			
			request.setAttribute("book", book);
			request.getRequestDispatcher("/book/book_edit.jsp").forward(request, response);
			break;

		case "delete":
			code = request.getParameter("code");

			bookDAO.delete(Integer.valueOf(code));
			response.sendRedirect(request.getContextPath() + "/book");
			break;

		default:
			String categoryId = request.getParameter("category");
			List<Book> books = new ArrayList<Book>();

			if (categoryId == null) {
				books = bookDAO.getAll();
				request.setAttribute("category", null);
			} else {
				books = bookDAO.getByCategoryId(Integer.valueOf(categoryId));

				if (books == null) {
					books = new ArrayList<Book>();
				}
				CategoryDAO categoryDAO = new CategoryDAOImpl();
				Category category = categoryDAO.findById(Integer.valueOf(categoryId));
				request.setAttribute("category", category.getTitle());
			}

			request.setAttribute("books", books);

			request.getRequestDispatcher("/book/book.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Book book;
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "create":
			book = getBookParam(request);
			bookDAO.create(book);
			break;
		case "edit":

			book = getBookParam(request);
			System.out.println(book);
			bookDAO.update(book);
			break;

		case "delete":
			String code = request.getParameter("code");
			bookDAO.delete(Integer.valueOf(code));
			break;

		default:
			break;
		}

		response.sendRedirect(request.getContextPath() + "/book");
	}

	private Book getBookParam(HttpServletRequest request) {
		String id = request.getParameter("id");
		String categoryId = request.getParameter("categoryId");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String yearOfPublication = request.getParameter("yearOfPublication");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String description = request.getParameter("description");

		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setCategory(new Category(Integer.valueOf(categoryId)));
		book.setPublisher(publisher);
		book.setYearOfPublication(yearOfPublication != null ? Integer.valueOf(yearOfPublication) : null);
		book.setQuantity(quantity != null ? Integer.valueOf(quantity) : 0);
		book.setPrice(price != null ? Float.valueOf(price) : 0);
		book.setDescription(description);
		if (id != null) {
			book.setId(Integer.valueOf(id));
			bookDAO.update(book);
		}

		return book;
	}
}
