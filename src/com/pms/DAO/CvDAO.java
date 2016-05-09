package com.pms.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pms.model.User;

public class CvDAO {
	
	
	public List<User> getStudentByType() {
		System.out.println("dao action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> students = null;
		String student = "student";
		try {
			students = (List<User>) session.createQuery(
					"From User u WHERE u.userType = '" + student + "'").list();
			System.out.println("students>>>>>" + students);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return students;
	}


}
