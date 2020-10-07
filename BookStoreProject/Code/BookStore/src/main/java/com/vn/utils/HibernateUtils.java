package com.vn.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	static SessionFactory sessionFactory = null;
	public static SessionFactory getSesstionFactory() {
		try {
			if(sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				
				sessionFactory = configuration.buildSessionFactory();		
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
