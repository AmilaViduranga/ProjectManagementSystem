package com.pms.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;

import com.opensymphony.xwork2.inject.util.Strings;
import com.pms.model.EnrolmentKey;
import com.pms.model.Group;
import com.pms.model.Login;
import com.pms.model.User;
public class UserDAO {
	
	
	/**
	 * authonticate the user
	 * @params login :- the current user login details
	 * @return :- the authonticated user
	 */
	public User userAuthonticate(Login login) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List<User> user = null;
		try {
			session.beginTransaction();
			String checkUser = login.getUserName();
			user = session.createQuery("FROM User u WHERE u.userIdNo = '"+checkUser+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return  user.get(0);
	}
	
	/**
	 * check whether the lecture going to sign up
	 * @params catagory :- the type of the user excist
	 * @return :- the password for particular given catagory  
	 */
	public EnrolmentKey lectureSignupAuthonticate(String catagory) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List<EnrolmentKey> password = null;
		try {
			session.beginTransaction();
			password = session.createQuery("FROM EnrolmentKey e WHERE e.catagory='"+catagory+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return password.get(0);
	}
	
	/**
	 * get the logged user
	 * @params individualLogin :- the logged user id
	 * @result :- return the excisting current user
	 */
	public User getUser(String individualLogin) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List<User> individualusers = null;
		try {
			session.beginTransaction();
			individualusers = 
				session.createQuery("FROM User u where u.userIdNo = :userIdNum").setString("userIdNum", individualLogin).list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		System.out.println("******"+individualusers);
		return individualusers.get(0);
	}
	
	
	/**
	 * get the unregisterd groups
	 */
	public List<User> getStudentUsersId(String type) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		String notRegistered = "notRegistered";
		List<User> users = null;
		try {
			session.beginTransaction();
			users = session.createQuery("FROM User u WHERE u.userType = '"+type+"' "
					+ "AND u.groupRegisteredState = '"+notRegistered+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return users;
	}
	
	/**
	 * This method use for check user already available
	 * 
	 * @param inputName User id number
	 * @return boolean 
	 * 
	 */
	
	public Boolean cheakUserAvailablity(String inputName) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> dbUser = 
			session.createQuery("FROM User u where u.userIdNo = :userIdNum").setString("userIdNum", inputName).list();
		System.out.println(">>>>>>>"+dbUser);
		if(dbUser.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public Boolean cheakUserEmailAvailablity(String inputEmail) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> dbEmail = 
			session.createQuery("FROM User u where u.userEmail = :userIdNum").setString("userIdNum", inputEmail).list();
		System.out.println(">>>>>>>"+dbEmail);
		if(dbEmail.isEmpty()){
			return false;
		}
		
		return true;
	}
	
}
