package com.vn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.config.HibernateConfiguration;
import com.vn.dao.BookDAO;
import com.vn.entity.Book;

public class BookDAOImpl implements BookDAO {
	static SessionFactory factory = HibernateConfiguration.getSesstionFactory();

	@Override
	public Book create(Book book) {
		Session session = null;
		try {

			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(book);
			transaction.commit();

			System.out.println("create a book successful!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (book.getId() == 0) {
			System.out.println("create a book Fail!");
		}
		return book;
	}

	@Override
	public Book update(Book book) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.update(book);
			transaction.commit();

			System.out.println("update a book successful!");
		} catch (Exception e) {
			System.out.println("update a book Fail!");
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}

	@Override
	public List<Book> getAll() {
		Session session = null;
		List<Book> list = null;
		try {
			list = new ArrayList<Book>();

			session = factory.openSession();

			list = session.createQuery("From Book", Book.class).getResultList(); // From table_name

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Book findById(int id) {
		Book book = null;
		Session session = null;
		try {

			session = factory.openSession();

			book = session.find(Book.class, id);

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}

	@Override
	public Integer delete(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Book book = findById(id);
			if (book != null) {
				session.delete(book);
				transaction.commit();

				System.out.println("Delete book has ID = " + id + " is successful!");
				return 1;
			} else {
				System.out.println("Book has ID = " + id + " not exists in DB");
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		System.out.println("Delete book has ID = " + id + " is Fail!");
		return -1;
	}

}
