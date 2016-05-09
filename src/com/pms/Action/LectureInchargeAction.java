package com.pms.Action;

import java.util.List;

import com.pms.DAO.LectureInchargeDAO;
import com.pms.DAO.ProjectDAO;
import com.pms.model.Group;
import com.pms.model.Project;

public class LectureInchargeAction {
	private List<Group> registeredGroups;
	private List<Project> allProjects;
	private List<Group> pendingProjectGroups;
	private List<Project> studentSelectedProjects;
	private String filterBy;
	private String filterType;
	private String projectId;
	private String acceptState;
	
	
	
	
	
	
	


	public List<Group> getPendingProjectGroups() {
		return pendingProjectGroups;
	}


	public void setPendingProjectGroups(List<Group> pendingProjectGroups) {
		this.pendingProjectGroups = pendingProjectGroups;
	}


	public void setStudentSelectedProjects(List<Project> studentSelectedProjects) {
		this.studentSelectedProjects = studentSelectedProjects;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getAcceptState() {
		return acceptState;
	}


	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}


	public String getFilterBy() {
		return filterBy;
	}


	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}


	public String getFilterType() {
		return filterType;
	}


	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}


	public List<Project> getAllProjects() {
		return allProjects;
	}


	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}


	public List<Group> getRegisteredGroups() {
		return registeredGroups;
	}


	public void setRegisteredGroups(List<Group> registeredGroups) {
		this.registeredGroups = registeredGroups;
	}

	/**
	 * get all the registered groups calling up to now handle here
	 */
	public String getAllRegisteredGroups() {
		LectureInchargeDAO dao = new LectureInchargeDAO();
		registeredGroups = dao.getAllRegisteredGroups();
		System.out.println("Registered groups at action"+registeredGroups);
		return "success";
	}
	/**
	 * all the project loading callings handle here
	 */
	public String getAllProjectsToLoad() {
		ProjectDAO dao = new ProjectDAO();
		allProjects = dao.getAllProject();
		loadGroupHavingPendingProjects();
		return "success";
	}
	
	
	public String getStudentSelectedProjects(){
		ProjectDAO dao = new ProjectDAO();
		studentSelectedProjects = dao.getStudentSelectedProjects();
		System.out.println("this is student selected projecs"+studentSelectedProjects);
		return "success";
	}
	/**
	 * this will filter the projects according to user request
	 */
	public String filterProject() {
		ProjectDAO dao = new ProjectDAO();
		if(this.filterType.equals("All")) {
			allProjects = dao.getAllProject();
		}
		if(this.filterType.equals("LecturerId")) {
			allProjects = dao.getSubmittedProject(this.filterBy);
		}
		if (this.filterType.equals("title")) {
			allProjects = dao.getAllProjectByTitle(this.filterBy);
		}
		if (this.filterType.equals("accepted")) {
			allProjects = dao.getAcceptedNotAcceptedProjects(true);
		}
		if (this.filterType.equals("notAccepted")) {
			allProjects = dao.getAcceptedNotAcceptedProjects(false);
		}
		return "success";
	}

	/**
	 * this will change the project state whether accepted or not accepted
	 */
	public String changeProjectState() {
		ProjectDAO dao = new ProjectDAO();
		boolean result = dao.changeAceptState(this.projectId, this.acceptState);
		if (result) {
			allProjects = dao.getAllProject();
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 *@author pasindu
	 *@see this will display all pending projects when user click view 
	 *lecture in charge projects
	 *@return success
	 */	
	public String loadGroupHavingPendingProjects(){
		
		ProjectDAO dao = new ProjectDAO();
		pendingProjectGroups = dao.getPendingProjects();
		return "success";
		
	}
	
	
	
	
}
