package com.pms.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class LoginAction extends ActionSupport {
	/*
	 * Variable diclaration 
	 */
	private Login login;
	/*
	 * Getters and Setters decalartion
	 */
	
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
	public String authonticateLogin() {
		UserDAO dao = new UserDAO();
		String password = dao.userAuthonticate(login);
		if (password.equals(login.getUserPassword())) {
			login.setLoginState("logged");
			return "success";
		} else {
			login.setLoginState("errorLogin");
			addActionError("invalid login");
			return "fail";
		}
		
	}
	
	
	
	
	

}
