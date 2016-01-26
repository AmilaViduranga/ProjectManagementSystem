package com.pms.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import com.opensymphony.xwork2.inject.util.Strings;
import com.pms.model.EnrolmentKey;
import com.pms.model.Login;
import com.pms.model.User;
public class UserDAO {
	public User userAuthonticate(Login login) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		String checkUser = login.getUserName();
		List<User> user = session.createQuery("FROM User u WHERE u.userIdNo = '"+checkUser+"'").list();
		return  user.get(0);
	}
	
	public EnrolmentKey lectureSignupAuthonticate(String catagory) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<EnrolmentKey> password = session.createQuery("FROM EnrolmentKey e WHERE e.catagory='"+catagory+"'").list();
		return password.get(0);
	}
	
	public User getUser(String individualLogin) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> individualusers = 
			session.createQuery("FROM User u where u.userIdNo = :userIdNum").setString("userIdNum", individualLogin).list();
		return individualusers.get(0);
	}
}
