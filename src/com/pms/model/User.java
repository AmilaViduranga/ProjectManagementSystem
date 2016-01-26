package com.pms.model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;

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

	@Column(name = "name")
	private String userName;

	@Column(name = "user_cgpa")
	private Double userCGPA;

	
	@Column(name = "user_contact_no")
	private String userContactNo;

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
	
	@Column(name = "is_sep")
	private Boolean isSep;

	@Column(name = "is_itp")
	private Boolean isITP;
	
	@Column(name = "photo")
	private File photo;

	private String photoFileName;
	private String photoContentType;

	
	
	
	
	
	
	// Getters And Setters
	
	
	
	
	
	public int getId() {
		return id;
	}

	public Boolean getIsSep() {
		return isSep;
	}

	public void setIsSep(Boolean isSep) {
		this.isSep = isSep;
	}

	public Boolean getIsITP() {
		return isITP;
	}

	public void setIsITP(Boolean isITP) {
		this.isITP = isITP;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getUserCGPA() {
		return userCGPA;
	}

	public void setUserCGPA(Double userCGPA) {
		this.userCGPA = userCGPA;
	}

	public String getUserContactNo() {
		return userContactNo;
	}

	
	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

}
