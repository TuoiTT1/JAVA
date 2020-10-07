package com.vn.main;

import java.util.List;

import com.vn.dao.AuthorDAO;
import com.vn.dao.impl.AuthorDAOImpl;
import com.vn.entitiy.Author;

public class Main {

	public static void main(String[] args) {

		AuthorDAO authorDAO = new AuthorDAOImpl();

		// create
		Author author = new Author();
		author.setAuthorName("Hamlet Trương");
		author.setAuthorAddress("Hồ Chí Minh");
		System.out.println("insert author: " + authorDAO.create(author));

		// get all
		List<Author> list = authorDAO.getAll();
		for (Author author1 : list) {
			System.out.println(author1);
		}

		// update
		author = new Author();
		author.setId(1);
		author.setAuthorName("Nam Cao");
		author.setAuthorAddress("Hà Nam");
		System.out.println("Updated: " + authorDAO.update(author));

		// get Author by ID
		System.out.println("Find Author has ID = 6: " + authorDAO.findById(6));

		// delete a author
		authorDAO.delete(7);
	}
}
