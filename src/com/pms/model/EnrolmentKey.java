package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pms_enrolmentkeys")
public class EnrolmentKey {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="catagory", unique=true)
	private String  catagory;
	
	@Column(name="enrolment_key", unique=true)
	private String  enrolmentKey;

	@Column (name="login_password", unique=true)
	private String  loginPassword; 
	
	public String getloginPassword() {
		return loginPassword;
	}

	public void setloginPassword(String password) {
		this.loginPassword = password;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getEnrolmentKey() {
		return enrolmentKey;
	}

	public void setEnrolmentKey(String enrolmentKey) {
		this.enrolmentKey = enrolmentKey;
	}
	
}
