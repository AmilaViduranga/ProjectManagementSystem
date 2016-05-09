package com.pms.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pms.model.Member;
import com.pms.model.User;

public class HodDAO {

	/**
	 * This class has Action related to HOD
	 * @author pasindu lakmal
	 *
	 */

	public List<User> getLectursByType() {
		System.out.println("dao action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> lecturers = null;
		String lecturer = "lecturer";
		try {
			lecturers = (List<User>) session.createQuery(
					"From User u WHERE u.userType = '" + lecturer + "'").list();
			System.out.println("lecturers>>>>>" + lecturers);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return lecturers;
	}

	/*
	 * This method is use for select user from id
	 * 
	 * @param selectedName user id
	 * 
	 * @return user
	 */

	public User getUserByName(String selectedName) {

		System.out.println("dao selectedName action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> selectduser = session
				.createQuery("FROM User u where u.userName = :userName")
				.setString("userName", selectedName).list();

		session.getTransaction().commit();

		return selectduser.get(0);
	}

	/*
	 * This method is use for get all lectures by type
	 * 
	 * @see lectuerers object with currernt lectures
	 * 
	 * @return lecturers
	 */

	public User getPreviousLecInCharge() {

		System.out.println("dao getPreviousLecInCharge action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> selectduser = session
				.createQuery(
						"FROM User u where u.isLecturerInCharge = :isLecturerInCharge")
				.setBoolean("isLecturerInCharge", true).list();

		session.getTransaction().commit();

		return selectduser.get(0);

	}

	/*
	 * This method is use for get all lectures by type
	 * 
	 * @see lectuerers object with currernt lectures
	 * 
	 * @return lecturers
	 */
	public List getStateOfLic() {

		System.out.println("dao getStateOfLic action called");
		Session session = DbConnectionManager.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("isLecturerInCharge", true));

		List results = cr.list();

		System.out.println("dao getStateOfLic action state" + results);

		return results;

	}

}
