package com.pms.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pms.model.Group;
//import com.pms.util.HibernateUtil;
import com.pms.model.Member;
import com.pms.model.User;

public class GroupRegistrationDAO {
	public Group getRegisteredGroups(String userName) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> groups = null;
		try {
			groups = (List<Group>)session.createQuery("FROM Group g WHERE g.memberId = '"+userName+"'").list();
			if(groups.size() == 0) {
				return null;
			}
		} catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return groups.get(0);
	}
	
	public List<Group> getMembersIndividualGroup(String groupId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> members = null;
		try {
			members = (List<Group>)session.createQuery("From Group g WHERE g.groupId = '"+groupId+"'").list();
			System.out.println("Members are "+ members);
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
//		session.getTransaction().commit();
		return members;
	}
	
	public boolean addMemberToGroup(Group group) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(group);
		String regState = "Registered";
		Query query = session.createQuery("UPDATE User u SET u.groupRegisteredState = '"+regState+"' WHERE u.userIdNo = '"+group.getMemberId()+"'");
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return true;
	}
	
	public String getCountOfRegisteredGroups(){
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List count = (List)session.createQuery("SELECT COUNT(g.groupId) FROM Group g").list();
		return count.get(0).toString();
	}
	
	public String getLeader(String userId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> user = (List<User>)session.createQuery("FROM User u WHERE u.userIdNo = '"+userId+"'").list();
		System.out.println("the user is at dao " +user.get(0).getUserName().toString());
		return user.get(0).getUserName();
	}
}
