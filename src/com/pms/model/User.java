package com.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "pms_user")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "regNo", unique = true)
	private String userIdNo;
	
	@Column(name = "password")
	private String userPassword;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "email")
	private String userEmail;
	
	@Column(name = "userType")
	private String userType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_register")
	private Date userDateOfRegister;
	
	@Column(name = "is_reset_password")
	private Boolean resetPassword;
	
	@Column(name = "image")
	private String userImage;
	
	@Column(name = "token")
	private String userToken;
	
	
	
	

	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserIdNo() {
		return userIdNo;
	}

	public void setUserIdNo(String userIdNo) {
		this.userIdNo = userIdNo;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserDateOfRegister() {
		return userDateOfRegister;
	}

	public void setUserDateOfRegister(Date userDateOfRegister) {
		this.userDateOfRegister = userDateOfRegister;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

}
