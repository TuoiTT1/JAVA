package com.vn.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSesstionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");

				sessionFactory = configuration.buildSessionFactory();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
