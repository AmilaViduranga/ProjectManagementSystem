package com.pms.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pms.model.Group;
//import com.pms.util.HibernateUtil;
import com.pms.model.Member;
import com.pms.model.Project;
import com.pms.model.User;
import com.pms.util.DB;
/**
 * handle the logic of the group registration, data reterieving and logic related to group
 */

public class GroupRegistrationDAO {
	/**
	 * get the group for particular given user name
	 * @param userName :- the user id of the user that need group
	 * @return : - group of the particular user
	 */
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
	public List<Group> getListOfMembersForProject(String userName){
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> groups = null;
		try {
			groups = (List<Group>)session.createQuery("FROM Group g WHERE g.memberId = "
					+ "'"+userName+"'").list();
			Group gp = groups.get(0);
			groups = (List<Group>)session.createQuery("FROM Group g WHERE g.groupId = '"+gp.getGroupId()+"'").list();
			if(groups.size() == 0) {
				return null;
			}
		} catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		System.out.println("***********group members are******"+groups);
        session.getTransaction().commit();
        return groups;
	}
	/**
	 * get the members of the particular given group id
	 * @params groupID :- the group id of the group
	 * @return :- all the members list of particular group
	 */
	
	public List<Group> getMembersIndividualGroup(String groupId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> members = null;
		try {
			members = (List<Group>)session.createQuery("From Group g WHERE "
					+ "g.groupId = '"+groupId+"'").list();
			System.out.println("Members are "+ members);
		} catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
		session.getTransaction().commit();
		return members;
	}
	
	/**
	 * add members to newly registered group and set that members are registered 
	 * @params group :- the group object newly registered
	 * @return true :- after registerd the group and change the state of registration
	 */
	public boolean addMemberToGroup(Group group) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.save(group);
			String regState = "Registered";
			Query query = session.createQuery("UPDATE User u SET u.groupRegisteredState = "
					+ "'"+regState+"' WHERE u.userIdNo = '"+group.getMemberId()+"'");
			int result = query.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return true;
	}
	
	/**
	 * get the total number of groups
	 * @return : - the total number of groups
	 */
	public String getCountOfRegisteredGroups(){
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List count = null;
		try {
			session.beginTransaction();
			count = (List)session.createQuery("SELECT COUNT(g.groupId) FROM Group g").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return count.get(0).toString();
	}
	
	/**
	 * get the leader name of the particular registered group
	 * @params userId :- the member id of particular user
	 * @return :- get the name of the leader
	 */
	public String getLeader(String userId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List<User> user = null;
		try {
			session.beginTransaction();
			user = (List<User>)session.createQuery("FROM User u WHERE u.userIdNo = '"+userId+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		User leader = user.get(0);
		session.getTransaction().commit();
		return leader.getUserName();
	} 
	/**
	 * check whether the particular user is a leader
	 * @params userId :- the particular user's id
	 * @return :- return true if he is leader, else false
	 */
	public boolean isLeaderLogedIn(String userId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		List<Group> member = null;
		try {
			session.beginTransaction();
			member = (List<Group>)session.createQuery("From Group g "
					+ "WHERE g.leaderId = '"+userId+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (member.isEmpty()) {
			return false;
		} 
		session.getTransaction().commit();
		return true;
	}
	
	public boolean isGroupRegistered(String userId) {
		System.out.println("The user is "+userId);
		List<Group> member = null;
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		member = (List<Group>)session.createQuery("FROM Group g WHERE g.memberId = '"+userId+"'").list();
		System.out.println("the member is"+member);
		if (member.isEmpty()) {
			session.getTransaction().commit();
			return false;
		}
		session.getTransaction().commit();
		return true;
	}
	
	/**
	 *@author pasindu
	 */
	
	public List<Group> getGroupSeperately(String groupId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Group group = null;
		List<Group> getResult = null;
		try {
			getResult = session.createQuery("FROM Group g WHERE "
					+ "g.groupId = '"+groupId+"'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return getResult;
	}
	

}
