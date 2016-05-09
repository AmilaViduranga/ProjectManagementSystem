package com.pms.DAO;

import java.util.List;
import com.pms.util.DB;
import org.hibernate.Session;

import com.pms.model.Group;
import com.pms.model.Project;

/**
 * Handle logic of the project class
 */

public class ProjectDAO {
	/**
	 * get the project of particular lecturer
	 * @params lecturerid :- the id of particular lecturer
	 * @return the projects that submitted by given lecturer id
	 */
	public List<Project> getSubmittedProject(String lectureId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> submittedProjects = null;
		try {
			submittedProjects = session.createQuery("FROM Project p "
					+ "WHERE p.lectureID LIKE '%"+lectureId+"%'").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (submittedProjects.size() == 0) {
			session.getTransaction().commit();
			return null;
		}
		session.getTransaction().commit();
		return submittedProjects;
	}
	
	/**
	 * get project individually by project id
	 * @params projectId :- the id of the project want to retrive
	 * @return :- project for paricular id
	 */
	public Project getProjectSeperately(String projectId) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Project project = null;
		List<Project> getResult = null;
		try {
			getResult = session.createQuery("FROM Project p WHERE "
					+ "p.projectId = '"+projectId+"'").list();
			project = getResult.get(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return project;
	}
	
	/*
	 * get all the projects
	 * @return :- get all the projects 
	 */
	public List<Project> getAllProject() {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> allProjects = null;
		try {
			allProjects = session.createQuery("FROM Project").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allProjects;
	}
	
	/**
	 * @author Pasindu
	 * @return
	 */
	public List<Group> getPendingProjects() {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Group> pendingP = null;
		try {
			pendingP = session.createQuery("FROM Group g WHERE "
					+ "g.lectureInchargeStatus = 'pending' GROUP BY g.groupId ORDER BY  g.groupId ").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return pendingP;
	}
	
	public List<Project> getStudentSelectedProjects() {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> allProjects = null;
		try {
			allProjects = session.createQuery("FROM Project").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allProjects;
	}
	
	
	/**
	 * get the project by project title
	 * @params title :- the value for search that want
	 * @result :- send the project for particular title
	 */
	public List<Project> getAllProjectByTitle(String title) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> allProjects = null;
		try {
			allProjects = session.createQuery("FROM Project p WHERE p.projectName = '"+title+""
					+ "'").list();
			if (allProjects == null) {
				session.getTransaction().commit();
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allProjects;
	}
	
	/**
	 * get the acepted and not acepted projects seperately according to 
	 * state 
	 * @params state :- the lecture incharge state accept or not the project
	 * @return :- all the project respect to state given
	 */
	public List<Project> getAcceptedNotAcceptedProjects(boolean state) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> allProjects = null;
		String queryToFilter = "";
		if (state) {
			queryToFilter = "FROM Project p WHERE p.projectAcceptStatus = true";
		} else {
			queryToFilter = "FROM Project p WHERE p.projectAcceptStatus = false";
		}
		try {
			allProjects = session.createQuery(queryToFilter).list();
			if (allProjects == null) {
				session.getTransaction().commit();
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allProjects;
	}
	
	/**
	 * change the state whether lecture incharge accept or not
	 * @params id :- the id of the project 
	 * @params state :- the state given by lecturer incharge (accept, notAccept)
	 * @result :- send true after complete updates
	 */
	public boolean changeAceptState(String id, String state) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Project project = new Project();
		project.setProjectId(Integer.parseInt(id));
		project = this.getProjectSeperately(id);
		try {
			if(state.equals("accept")) {
				project.setProjectAcceptStatus(true);	
			} else if (state.equals("notAccept")) {
				project.setProjectAcceptStatus(false);
			}
			DB.update(project);
		} catch(Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return true;
	}
	
	/**
	 * get the list of projects that are not assigned
	 * @return :- unassign projects
	 */
	public List<Project> getAcceptedProjects() {
		
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<Project> acceptedProjects = session.createQuery("FROM Project p WHERE  p.projectAcceptStatus = true ").list();
		session.getTransaction().commit();
		
		return acceptedProjects;
	}
	
	/**
	 * update project assignment
	 */
	public boolean updateProjectAssignment(String projectId,String memberId,String projectComment,String projectTechnology) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			GroupRegistrationDAO dao = new GroupRegistrationDAO();
			List<Group> groups = dao.getListOfMembersForProject(memberId);
			for(int i=0; i<groups.size(); i++) {
				Group group = groups.get(i);
				group.setLectureInchargeStatus("pending");
				group.setProjectComment(projectComment);
				group.setProjectId(projectId);
				group.setTechnology(projectTechnology);
				DB.update(group);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
