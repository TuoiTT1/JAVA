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
import com.vn.dao.impl.BookDAOImpl;
import com.vn.entity.Book;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> books = bookDAO.getAll();

		if (books == null)
			books = new ArrayList<Book>();

		request.setAttribute("books", books);
		request.getRequestDispatcher("/book/book.jsp").forward(request, response);
	}

}
