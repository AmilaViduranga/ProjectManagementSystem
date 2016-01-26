package com.pms.Action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;
	
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
			sessionMap.put("userIdNo", login.getUserName());
			return "success";
		} else {
			login.setLoginState("errorLogin");
			addActionError("invalid login");
			return "fail";
		}
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	
	
	
	
	

}
