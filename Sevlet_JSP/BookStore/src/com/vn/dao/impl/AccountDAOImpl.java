package com.vn.dao.impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.config.HibernateConfiguration;
import com.vn.dao.AccountDAO;
import com.vn.entity.Account;

public class AccountDAOImpl implements AccountDAO {

	static SessionFactory factory = HibernateConfiguration.getSesstionFactory();

	@Override
	public Account findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account login(String userName, String password) {
		Session session = null;
		Account account = null;
		try {
			session = factory.openSession();
			String hql = "From Account a WHERE UserName = :userName and Password = :password";
			Query query = session.createQuery(hql, Account.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);

			Object o = query.getSingleResult();
			if (o != null) {
				account = (Account) o;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return account;
	}

}
