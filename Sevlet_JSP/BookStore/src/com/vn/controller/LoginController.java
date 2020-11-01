package com.vn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vn.dao.AccountDAO;
import com.vn.dao.impl.AccountDAOImpl;
import com.vn.entity.Account;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountDAO accountDAO = new AccountDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Account account = accountDAO.login(userName, password);
		if (account == null) {
			request.setAttribute("message", "Thông tin đăng nhập sai!");

			session.setAttribute("userName", null);
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		} else {
			session.setAttribute("userName", account.getUserName());

			response.sendRedirect(request.getContextPath() + "/book");
		}

	}

}
