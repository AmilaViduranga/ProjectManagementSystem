package com.pms.DAO;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.inject.util.Strings;
import com.pms.model.Login;
import com.pms.model.User;

public class UserDAO {
	public String userAuthonticate(Login login) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		String password = (String)session.createCriteria(User.class)
		.add(Restrictions.eq("userIdNo", login.getUserName()))
		.setProjection(Projections.property("userPassword"))
		.uniqueResult(); 
		return password;
	}
//	
//	public List<User> getUser() {
////		Login login = new Login();
//		Session session = DbConnectionManager.getSessionFactory().openSession();
//		session.beginTransaction();
//		List users = null;
//		try {
////			String userName = login.getUserName();
////			System.out.print(userName);
//			String userName = "tt";
//			System.out.println(session.createQuery("FROM User u WHERE u.userIdNo = '"+userName+"'"));
//			users = (List<User>)session.createQuery("FROM User u WHERE u.userIdNo = '"+userName+"'");
//		} catch (Exception e) {
//			System.out.print(e);
//			session.getTransaction().rollback();
//		}
//		session.getTransaction().commit();
//		return users;
//	}
	
	public User getUser(String individualLogin) {

	Session session = DbConnectionManager.getSessionFactory().openSession();
	session.beginTransaction();
	
	List<User> individualusers = 
		session.createQuery("FROM User u where u.userIdNo = :userIdNum").setString("userIdNum", individualLogin).list();
	
	
	return individualusers.get(0);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
