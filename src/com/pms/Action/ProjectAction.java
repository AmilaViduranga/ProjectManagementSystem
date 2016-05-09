//Action class for Project

package com.pms.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.ProjectDAO;
import com.pms.model.Group;
import com.pms.model.Login;
import com.pms.model.Project;
import com.pms.model.User;
import com.pms.util.DB;

public class ProjectAction extends ActionSupport implements SessionAware{
	
	// declaring variables
	private Project project;
	private List projectList;
	private String projectId;
	private String projectName;
	private Map<String, Object> sessionMap;
	private List<Project> submittedProjectList;
	private List<Project> acceptedProjects;
	private boolean isRegistered;
	private String language;
	private String technology;
	private String projectState;
	
	//Getters and Setters for private attributes
	
	
	public Project getProject() {
		return project;
	}
	public String getProjectState() {
		return projectState;
	}
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public boolean isRegistered() {
		return isRegistered;
	}
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public List<Project> getAcceptedProjects() {
		return acceptedProjects;
	}
	public void setAcceptedProjects(List<Project> acceptedProjects) {
		this.acceptedProjects = acceptedProjects;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Project> getSubmittedProjectList() {
		return submittedProjectList;
	}
	public void setSubmittedProjectList(List<Project> submittedProjectList) {
		this.submittedProjectList = submittedProjectList;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List getProjectList() {
		return projectList;
	}
	public void setProjectList(List projectList) {
		this.projectList = projectList;
	}
	
	/**
	 * Add new project
	 */
	public String add_Project(){
		System.out.println("the current project submitter "+(String)sessionMap.get("userIdNo"));
		project.setLectureID((String)sessionMap.get("userIdNo"));
		project.setAssigned(false);
		DB.save(project);
		projectList = DB.list(Project.class);
		return this.getAllProjects();
	}

	public String execute() {
		projectList = DB.list(User.class);
		return SUCCESS;
	}
	
	/**
	 * get all the projects without any condition
	 */
	public String getAllProjects() {
		ProjectDAO dao = new ProjectDAO();
		submittedProjectList = dao.getSubmittedProject((String)sessionMap.get("userIdNo"));
		return "success";
	}
	
	/**
	 * get projects individually respect to condition 
	 */
	public String getProjectIndividually() {
		ProjectDAO dao = new ProjectDAO();
		project = dao.getProjectSeperately(projectId);
		return "success";
	}
	
	/**
	 * get assigned projects
	 */
	public String getAcceptedProject() {
		System.out.println("Function called");
		GroupRegistrationDAO groupDao = new GroupRegistrationDAO();
		boolean isRegisteredGroup = groupDao.isGroupRegistered((String)sessionMap.get("userIdNo"));
		System.out.println("is registered = "+isRegisteredGroup);
		if (isRegisteredGroup == true) {
			Group group = groupDao.getRegisteredGroups((String)sessionMap.get("userIdNo"));
			ProjectDAO dao = new ProjectDAO();
			if (group.getProjectId().equals("notSelected")|| group.getLectureInchargeStatus().equals("notAccepted")) {
				acceptedProjects = dao.getAcceptedProjects();
			} else {
				projectState = group.getLectureInchargeStatus();
				Project project = dao.getProjectSeperately(group.getProjectId());
				acceptedProjects = new ArrayList<Project>();
				acceptedProjects.add(project);
			}
			sessionMap.put("isRegisteredGroup", "registered");
		} else {
			sessionMap.put("isRegisteredGroup", "notregistered");
		}
		return "success";
	}
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	/**
	 * set assigned project
	 */
	public String updateProjectAssignment() {
		ProjectDAO dao = new ProjectDAO();
		String member = (String)sessionMap.get("userIdNo");
		boolean result = dao.updateProjectAssignment(projectId,member,technology,language);
		if (result) {
			getAcceptedProject();
			addActionMessage("Successfully assigned");
		} else {
			addActionError("Not assigned properly");
		}
		return "success";
	}
}
