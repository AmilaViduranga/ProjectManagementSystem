package com.pms.Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.AdminDAO;
import com.pms.model.Cv;
import com.pms.model.EnrolmentKey;
import com.pms.model.Project;
import com.pms.model.User;

public class AdminAction extends ActionSupport{
	
	private List<User> adminUserList;
	private List<Project> adminProjectList;
	private List<EnrolmentKey> adminEnrolmentKeyList;
	private List<Cv> adminCVList;
	private List<EnrolmentKey> enrolmentKeys;
	private String adminUserSearchBy;
	private String userIdNo;
	private User user;
	private String userName;
	private String userGPA;
	private String userContactNo;
	private String userPassword;
	private String userEmail;
	private String isSep;
	private String isITP;
	private String isLecturerInCharge;
	private String userType;
	
	
	
	public List<EnrolmentKey> getEnrolmentKeys() {
		return enrolmentKeys;
	}
	public void setEnrolmentKeys(List<EnrolmentKey> enrolmentKeys) {
		this.enrolmentKeys = enrolmentKeys;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGPA() {
		return userGPA;
	}
	public void setUserGPA(String userGPA) {
		this.userGPA = userGPA;
	}
	public String getUserContactNo() {
		return userContactNo;
	}
	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
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
	public String getIsSep() {
		return isSep;
	}
	public void setIsSep(String isSep) {
		this.isSep = isSep;
	}
	public String getIsITP() {
		return isITP;
	}
	public void setIsITP(String isITP) {
		this.isITP = isITP;
	}
	public String getIsLecturerInCharge() {
		return isLecturerInCharge;
	}
	public void setIsLecturerInCharge(String isLecturerInCharge) {
		this.isLecturerInCharge = isLecturerInCharge;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserIdNo() {
		return userIdNo;
	}
	public void setUserIdNo(String userIdNo) {
		this.userIdNo = userIdNo;
	}
	public String getAdminUserSearchBy() {
		return adminUserSearchBy;
	}
	public void setAdminUserSearchBy(String adminUserSearchBy) {
		this.adminUserSearchBy = adminUserSearchBy;
	}

	private AdminDAO dao = new AdminDAO();
	
	public List<User> getAdminUserList() {
		return adminUserList;
	}
	public void setAdminUserList(List<User> adminUserList) {
		this.adminUserList = adminUserList;
	}
	public List<Project> getAdminProjectList() {
		return adminProjectList;
	}
	public void setAdminProjectList(List<Project> adminProjectList) {
		this.adminProjectList = adminProjectList;
	}
	public List<EnrolmentKey> getAdminEnrolmentKeyList() {
		return adminEnrolmentKeyList;
	}
	public void setAdminEnrolmentKeyList(List<EnrolmentKey> adminEnrolmentKeyList) {
		this.adminEnrolmentKeyList = adminEnrolmentKeyList;
	}
	public List<Cv> getAdminCVList() {
		return adminCVList;
	}
	public void setAdminCVList(List<Cv> adminCVList) {
		this.adminCVList = adminCVList;
	}
	
	public String getAllUsers() {
		adminUserList = dao.getAllUsersAvailable();
		return "success";
	}
	
	public String searchUser() {
		adminUserList = dao.searchUser(this.adminUserSearchBy);
		System.out.println("The list is "+adminUserList);
		return "success";
	}
	
	public String getUserIndividually() {
		user = dao.getIndividuallyUser(this.userIdNo);
		return "success";
	}
	
	/**
	 * delete excisting user
	 */
	
	public String deleteUser() {
		User user = new User();
		user.setUserIdNo(this.userIdNo);
		Boolean result = false;
		result = dao.deleteExcstingUser(user);
		if(result) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * update excsting user
	 */
	public String updateUser() {
		user = new User();
		user.setUserIdNo(this.userIdNo);
		user.setUserName(this.userName);
		user.setUserCGPA(Double.parseDouble(this.userGPA));
		user.setUserContactNo(this.userContactNo);
		user.setUserPassword(this.userPassword);
		user.setUserEmail(this.userEmail);
		user.setIsSep(Boolean.parseBoolean(this.isSep));
		user.setIsITP(Boolean.parseBoolean(this.isITP));
		user.setUserType(this.userType);
		
		Boolean result = dao.updateUser(user);
		if(result == true) {
			addActionMessage("Successfully updated");
			return "success";
		} else {
			addActionError("Error going on");
			return "fail";
		}
	}
	
	/**
	 * Enrolment keys managing
	 */
	
	public String getAllEnrolmentKeys() {
		enrolmentKeys = dao.getAllEnrolmentKeys();
		return "success";
	}
	
}
