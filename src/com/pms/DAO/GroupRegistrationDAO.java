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
			String type = "Leader";
			groups = (List<Member>)session.createQuery("FROM Member m WHERE m.memberType = '"+type+"' GROUP BY m.groupId").list();
			
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return groups;
	}
	
	public List<Member> getMembersIndividualGroup(String groupId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Member> members = null;
		try {
			members = (List<Member>)session.createQuery("From Member m WHERE m.groupId = '"+groupId+"'").list();
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		session.getTransaction().commit();
		return members;
	}
}
