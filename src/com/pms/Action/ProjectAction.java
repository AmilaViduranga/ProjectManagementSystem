//Action class for Project

package com.pms.Action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Group;
import com.pms.model.Login;
import com.pms.model.Project;
import com.pms.model.User;
import com.pms.util.DB;

public class ProjectAction extends ActionSupport{
	
	// declaring variables
	private Project project;
	private List projectList;
	
	//Getters and Setters for private attributes
	public Project getProject() {
		return project;
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
	
	
	//method declaration
	 
	// add a new group
	public String add_Project(){
		DB.save(project);
		projectList = DB.list(Project.class);
		return "success";
	}

	public String delete() {
		DB.delete(project);
		projectList = DB.list(User.class);
		return SUCCESS;
	}

	public String execute() {
		projectList = DB.list(User.class);
		return SUCCESS;
	}
	
	

}
