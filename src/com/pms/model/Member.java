package com.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pms_member")
public class Member {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "member_id_No", unique = true)
	private String memberIdNo;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "member_email")
	private String memberEmail;

	@Column(name = "cgpa")
	private Double cgpa;

	@Column(name = "contact_no")
	private Date contactNo;

	@Column(name = "member_type")
	private Boolean memberType;

	@Column(name = "cv")
	private String cv;
	
	
	@Column(name = "group_Id", unique = true)
	private String groupId;
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	@Column(name = "group_type")
	private String groupType;
	
	public String getIdNo() {
		return memberIdNo;
	}

	public void setIdNo(String idNo) {
		this.memberIdNo = idNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public Date getContactNo() {
		return contactNo;
	}

	public void setContactNo(Date contactNo) {
		this.contactNo = contactNo;
	}

	public Boolean getMemberType() {
		return memberType;
	}

	public void setMemberType(Boolean memberType) {
		this.memberType = memberType;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

}
