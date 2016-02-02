package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name="contactInfo")

public class ContactInfo {
	
	@Id 
	@GeneratedValue
	private int contactID;
	
	@Column(name = "name")
	private String userName;
	
	@Column(name = "regNo")
	private String userRegNo;
	
	@Column(name = "email")
	private String userEmail;
	
	@Column(name = "subject")
	private String userInquirySubject;
	
	@Column(name = "message")
	@Lob
	private String userMessage;
	
	

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRegNo() {
		return userRegNo;
	}

	public void setUserRegNo(String userRegNo) {
		this.userRegNo = userRegNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInquirySubject() {
		return userInquirySubject;
	}

	public void setUserInquirySubject(String userInquirySubject) {
		this.userInquirySubject = userInquirySubject;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	

}
