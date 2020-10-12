package com.vn.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.config.HibernateConfiguration;
import com.vn.dao.CategoryDAO;
import com.vn.entity.Category;

public class CategoryDAOImpl implements CategoryDAO {
	static SessionFactory factory = HibernateConfiguration.getSesstionFactory();

	@Override
	public Category create(Category category) {
		Session session = null;
		try {

			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(category);
			transaction.commit();

			System.out.println("create a category successful!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (category.getId() == 0) {
			System.out.println("create a category Fail!");
		}
		return category;
	}

	@Override
	public Category update(Category category) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.update(category);
			transaction.commit();

			System.out.println("update a category successful!");
		} catch (Exception e) {
			System.out.println("update a category Fail!");
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return category;
	}

	@Override
	public List<Category> getAll() {
		Session session = null;
		List<Category> list = null;
		try {
			list = new ArrayList<Category>();

			session = factory.openSession();

			list = session.createQuery("From Category", Category.class).getResultList(); // From table_name

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
	public Category findById(int id) {
		Category category = null;
		Session session = null;
		try {

			session = factory.openSession();

			category = session.find(Category.class, id);

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return category;
	}

	@Override
	public Integer delete(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Category author = findById(id);
			if (author != null) {
				session.delete(author);
				transaction.commit();

				System.out.println("Delete author has ID = " + id + " is successful!");
				return 1;
			} else {
				System.out.println("Author has ID = " + id + " not exists in DB");
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		System.out.println("Delete author has ID = " + id + " is Fail!");
		return -1;
	}

}
