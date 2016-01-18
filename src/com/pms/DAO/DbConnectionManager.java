package com.pms.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnectionManager {

	private static SessionFactory sessionFactory = null;
	
	private DbConnectionManager() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null || sessionFactory.isClosed()) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static boolean shutDown() {
		boolean result = false;
		try {	
			sessionFactory.close();
			result = true;
		}catch(Exception e) {
			result = false;
		}
		return result;
	}

}
