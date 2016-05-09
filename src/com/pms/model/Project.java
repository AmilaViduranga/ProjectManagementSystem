//Model Class for Project

package com.pms.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pms_project")
public class Project {

	
	// declaring variables
	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private int projectId;
	
	
	@Column(name = "lecturer_name")
	private String lecturerName;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "project_description")
	private String projectDescription;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "client_contact_no")
	private String clientContactNo;
	
	@Column(name = "client_email")
	private String clientEmail;
	
	@Column(name = "project_accept_status")
	private boolean projectAcceptStatus;
	
	@Column (name="lecture_id")
	private String lectureID;
	
	@Column (name="is_Asigned")
	private boolean isAssigned;
	
	
	
	//Getters and Setters for private attributes
	
	
	
	
	public String getLectureID() {
		return lectureID;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public void setLectureID(String lectureID) {
		this.lectureID = lectureID;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientContactNo() {
		return clientContactNo;
	}

	public void setClientContactNo(String clientContactNo) {
		this.clientContactNo = clientContactNo;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public boolean isProjectAcceptStatus() {
		return projectAcceptStatus;
	}

	public void setProjectAcceptStatus(boolean projectAcceptStatus) {
		this.projectAcceptStatus = projectAcceptStatus;
	}
	
	
}
