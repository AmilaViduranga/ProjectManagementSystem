package com.pms.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pms.model.Group;
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
	
	public boolean addMemberToGroup(Group group) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
//		int count = this.getCountOfRegisteredGroups()+1;
//		group.setGroupId(count);
//		System.out.println("The Group id is "+ count);
		session.save(group);
		String regState = "Registered";
		Query query = session.createQuery("UPDATE User u SET u.groupRegisteredState = '"+regState+"' WHERE u.userIdNo = '"+group.getMemberId()+"'");
		int result = query.executeUpdate();
		
		session.getTransaction().commit();
		return true;
	}
	
	public List getCountOfRegisteredGroups(){
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List count = (List)session.createQuery("SELECT COUNT(g.groupId) FROM Group g GROUP BY g.groupId").list();
		return count;
	}
}
