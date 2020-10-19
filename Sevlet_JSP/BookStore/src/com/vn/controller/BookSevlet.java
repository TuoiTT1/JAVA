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
 * Servlet implementation class BookSevlet
 */
@WebServlet("/book")
public class BookSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static private BookDAO bookDAO = new BookDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> books = new ArrayList<Book>();
		books = bookDAO.getAll();
		request.setAttribute("books", books);

		request.getRequestDispatcher("book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
