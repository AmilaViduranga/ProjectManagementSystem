package com.pms.util;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB {
	/**
	 * This class includes Genaric method for all basic functions
	 * @author pasindu lakmal
	 */

	public static SessionFactory sf = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	/**
	 * This method save any object
	 * 
	 * @param obj Object
	 * 
	 * @return void
	 */
	public static void save(Object obj) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
	}

	/**
	 * This method delete any object
	 * 
	 * @param obj Object
	 * 
	 * @return void
	 */

	public static void delete(Object obj) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
	}

	/**
	 * This method upload any object
	 * 
	 * @param obj Object
	 * 
	 * @return void
	 */
	public static void update(Object obj) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
	}

	/**
	 * This method update list of objects
	 * 
	 * @param cls class
	 * 
	 * @return List
	 */

	public static List list(Class cls) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		return session.createCriteria(cls).list();
	}
}
