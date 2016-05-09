package com.pms.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pms_student_group")
public class Group {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@Column(name = "group_id")
	private String groupId;
	
	@Column(name = "leader_id")
	private String leaderId;
	
	@Column (name = "member_id")
	private String memberId;
	
	@Column (name = "project_id")
	private String projectId;
	
	@Column (name = "project_comment")
	private String projectComment;
	
	@Column (name = "lecture_Incharge_status")
	private String lectureInchargeStatus;
	
	@Column (name = "project_Technology")
	private String technology;
	
	

	// getters and setters
	
	
	
	
	public int getId() {
		return id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectComment() {
		return projectComment;
	}

	public void setProjectComment(String projectComment) {
		this.projectComment = projectComment;
	}

	public String getLectureInchargeStatus() {
		return lectureInchargeStatus;
	}

	public void setLectureInchargeStatus(String lectureInchargeStatus) {
		this.lectureInchargeStatus = lectureInchargeStatus;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
}
