package com.pms.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pms.model.Member;
import com.pms.model.User;

public class HodDAO {

	
	

	public List<User> getLectursByType() {
		System.out.println("dao action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> lecturers = null;
		String lecturer = "lecturer";
		try {
			lecturers = (List<User>)session.createQuery("From User u WHERE u.userType = '"+lecturer+"'").list();
			System.out.println("lecturers>>>>>"+lecturers);
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		session.getTransaction().commit();
		return lecturers;
	}
	
	
	public User getUserByName(String selectedName){
		
		System.out.println("dao selectedName action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> selectduser = 
			session.createQuery("FROM User u where u.userName = :userName").setString("userName", selectedName).list();
		
		
		session.getTransaction().commit();
		
		return selectduser.get(0);
	}
	
   public User getPreviousLecInCharge(){
		
		System.out.println("dao getPreviousLecInCharge action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> selectduser = 
			session.createQuery("FROM User u where u.isLecturerInCharge = :isLecturerInCharge").setBoolean("isLecturerInCharge", true).list();
			
		session.getTransaction().commit();
		
		return selectduser.get(0);
	}
	
	
}
