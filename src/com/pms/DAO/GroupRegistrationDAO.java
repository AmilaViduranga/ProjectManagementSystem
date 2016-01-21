package com.pms.DAO;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;


//import com.pms.util.HibernateUtil;
import com.pms.model.Member;

public class GroupRegistrationDAO {
	public List<Member> getRegisteredGroups() {
		
		
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Member> groups = null;
		try {
			groups = (List<Member>)session.createQuery("from Member").list();
			
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        System.out.println(groups);
        return groups;
	}
}
