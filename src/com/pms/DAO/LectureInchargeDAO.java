package com.pms.DAO;

import java.util.List;

import org.hibernate.Session;

import com.pms.model.Group;

public class LectureInchargeDAO {
	public List<Group> getAllRegisteredGroups() {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> groups = null;
		try {
			groups = (List<Group>)session.createQuery("FROM Group g Group By g.groupId").list();
			if(groups.size() == 0) {
				return null;
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        System.out.println("Groups are"+groups);
        return groups;
	}
}
