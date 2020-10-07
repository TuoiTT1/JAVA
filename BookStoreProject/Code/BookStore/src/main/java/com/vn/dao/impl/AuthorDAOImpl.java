package com.vn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.dao.AuthorDAO;
import com.vn.entitiy.Author;
import com.vn.utils.HibernateUtils;

public class AuthorDAOImpl implements AuthorDAO {

	static SessionFactory factory;

	@Override
	public Integer delete(int id) {
		try {
			factory = HibernateUtils.getSesstionFactory();

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Author author = findById(id);
			if (author != null) {
				session.delete(author);
				transaction.commit();

				session.close();
				System.out.println("Delete author has ID = " + id + " is successful!");
				return 1;
			} else {
				System.out.println("Author has ID = " + id + " not exists in DB");
			}
			session.close();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Delete author has ID = " + id + " is Fail!");
		return -1;
	}

	@Override
	public Author create(Author author) {
		try {
			factory = HibernateUtils.getSesstionFactory();

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(author);
			transaction.commit();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public Author update(Author author) {
		try {
			factory = HibernateUtils.getSesstionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.update(author);
			transaction.commit();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return author;
	}

	@Override
	public List<Author> getAll() {
		List<Author> list = null;
		try {
			list = new ArrayList<Author>();

			factory = HibernateUtils.getSesstionFactory();

			Session session = factory.openSession();

			list = session.createQuery("From author", Author.class).getResultList(); // From table_name

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Author findById(int id) {
		Author author = null;
		try {
			factory = HibernateUtils.getSesstionFactory();

			Session session = factory.openSession();

			author = session.find(Author.class, id);

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}

}
