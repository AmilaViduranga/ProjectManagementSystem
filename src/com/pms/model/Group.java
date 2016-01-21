package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pms_group")
public class Group {

	
	@Column(name = "idNo", unique = true)
	private String idNo;
	
	@Column(name = "group_type")
	private String groupType;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	
	
	
	
	

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
