package com.pms.Action;

import java.util.List;

import com.pms.util.DB;
import com.pms.DAO.ContactDAO;
import com.pms.model.ContactInfo;
import com.opensymphony.xwork2.ActionSupport;


public class ContactInfoAction extends ActionSupport {

	private ContactInfo contactInfo;
	private List contactInfoList;
	
	
	
	public ContactInfo getConInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public List getContactInfoList() {
		return contactInfoList;
	}
	public void setContactInfoList(List ContactInfoList) {
		this.contactInfoList = ContactInfoList;
	}
	
	
	
	
	public String add(){
		boolean result = false;
		try {
			ContactDAO dao = new ContactDAO();
			result = dao.addContact(contactInfo);
			if (result) {
				return "success";
			}
		} catch (Exception e) {
			return ERROR;
		}
		return "notSuccess";
	}
	
	
	
	
}
