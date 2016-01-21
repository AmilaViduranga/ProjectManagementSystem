package com.pms.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

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
}
