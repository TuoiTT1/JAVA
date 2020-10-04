package com.vn.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.vn.connection.MySQLConnection;
import com.vn.dao.AuthorDAO;
import com.vn.dao.AuthorDAOImpl;
import com.vn.entity.Author;

public class Main {

	public static void main(String[] args) {
		Connection connection = MySQLConnection.getConnection();

		AuthorDAO authorDAO = new AuthorDAOImpl(connection);
		Author author;

		// create
		author = new Author();
		author.setAuthorName("Nguyen Nhat Anh");
		author.setAuthorAddress("Quang Nam");

		System.out.println("Insert a author: " + author);
		if (authorDAO.create(author) != -1) {
			System.out.println("Insert a author successful!");
		} else {
			System.out.println("Error when insert a author");
		}
		// read all
		System.out.println("\nGet all authors in database:");
		List<Author> authors = new ArrayList<Author>();
		authors = authorDAO.getll();
		for (Author author2 : authors) {
			System.out.println(author2);
		}

		// read by id
		System.out.println("\nFind a author by id = 1");
		author = authorDAO.findById(1);
		System.out.println(author);

		// update
		author = new Author();
		author.setId(6);
		author.setAuthorName("Nguyễn Nhật Ánh");
		author.setAuthorAddress("Quảng Nam");

		System.out.println("\nUpdate a author: id = 6");
		if (authorDAO.update(author) != -1) {
			System.out.println("Update a author successful!");
		} else {
			System.out.println("Error when Update a author");
		}
		// delete
		System.out.println("\nDelete a author: id = 3");
		if (authorDAO.delete(3) != -1) {
			System.out.println("Delete a author successful!");
		} else {
			System.out.println("Error when Delete a author");
		}

		// read all
		System.out.println("\nGet all authors in database:");
		authors = new ArrayList<Author>();
		authors = authorDAO.getll();
		for (Author author2 : authors) {
			System.out.println(author2);
		}

	}
}
