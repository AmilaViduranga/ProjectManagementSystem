package com.pms.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.UserDAO;
import com.pms.model.EnrolmentKey;
import com.pms.model.Login;


public class LoginAction extends ActionSupport {
	/*
	 * Variable diclaration 
	 */
	private Login login;
	private String userPassword;
	/*
	 * Getters and Setters decalartion
	 */
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	/*
	 * Methods
	 */
	// authonticate the user at login state
//	public String authonticateLogin() {
//		UserDAO dao = new UserDAO();
//		String password = dao.userAuthonticate(login);
//		if (password.equals(login.getUserPassword())) {
//			login.setLoginState("logged");
//			GroupRegistrationAction groupAction = new GroupRegistrationAction();
//			return groupAction.execute();
//		} else {
//			login.setLoginState("errorLogin");
//			addActionError("invalid login");
//			return "fail";
//		}
//		
//	}
	
	public String authonticateLecturer() {
		System.out.println("action Called");
		UserDAO dao = new UserDAO();
		EnrolmentKey enrolment = dao.lectureSignupAuthonticate("lecturer");
		String password = enrolment.getloginPassword();
		if (password.equals(this.getUserPassword())) {
			return "success";
		} else {
			addActionError("invalid Login");
			return "fail";
		}
	}
	
	
	

}
