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
@Table(name = "member")
public class Member {

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@Column(name = "idNo", unique = true)
	private String idNo;

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
	
	
	
	
	
	

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
