package com.pms.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pms.model.Cv;
import com.pms.model.EnrolmentKey;
import com.pms.model.Group;
import com.pms.model.User;
import com.pms.util.DB;

public class AdminDAO {

	List<User> allUsers = null;
	public List<User> getAllUsersAvailable() {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			allUsers = (List<User>)session.createQuery("FROM User").list();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return allUsers;
	}
	
	public List<User> searchUser(String searchVal) {
		System.out.println("The value searched is "+searchVal);
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			allUsers = (List<User>)session.createQuery("FROM User u WHERE u.userName LIKE '%"+searchVal+"%'").list();
			System.out.println("the value at dao are "+allUsers);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return allUsers;
	}
	
	public User getIndividuallyUser(String userId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		User user = null;
		try {
			allUsers = (List<User>)session.createQuery("FROM User u WHERE u.userIdNo = '"+userId+"'").list();
			user = allUsers.get(0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return user;
	}
	
	/**
	 * delete the user
	 */
	public Boolean deleteExcstingUser(User user) {
		User excistingUser = new User(); 
		UserDAO userDao = new UserDAO();
		excistingUser = userDao.getUser(user.getUserIdNo());
		DB.delete(excistingUser);
		return true;
	}
	
	/**
	 * update user
	 */
	
	public Boolean updateUser(User user) {
		User excistingUser = new User(); 
		UserDAO userDao = new UserDAO();
		excistingUser = userDao.getUser(user.getUserIdNo());
		System.out.println("*********"+excistingUser);
		excistingUser.setUserName(user.getUserName());
		excistingUser.setUserCGPA(user.getUserCGPA());
		excistingUser.setUserContactNo(user.getUserContactNo());
		excistingUser.setUserPassword(user.getUserPassword());
		excistingUser.setUserEmail(user.getUserEmail());
		excistingUser.setIsSep(user.getIsSep());
		excistingUser.setIsITP(user.getIsITP());
		excistingUser.setUserType(user.getUserType());
		DB.update(excistingUser);
		return true;
	}
	
	/**
	 * get enrolment keys
	 */
	
	public List<EnrolmentKey> getAllEnrolmentKeys() {
		List<EnrolmentKey> enrolmentKeys = null;
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			enrolmentKeys = (List<EnrolmentKey>)session.createQuery("FROM EnrolmentKey").list();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
		return enrolmentKeys;
	}

}
