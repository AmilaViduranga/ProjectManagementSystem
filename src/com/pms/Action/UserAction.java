package com.pms.Action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.pms.DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Login;
import com.pms.model.User;
import com.pms.util.DB;

public class UserAction extends ActionSupport implements SessionAware {

	private Map<String, Object> sessionMap;

	/*
	 * Action class for user
	 */
	// declaring variables
	private User user;
	private List userList;
	private Login login;
	private User individualUser;

	/*
	 * Getters and Setters for private attributes
	 */

	public User getUser() {
		return user;
	}

	public User getIndividualUser() {
		return individualUser;
	}

	public void setIndividualUser(User individualUser) {
		this.individualUser = individualUser;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	/*
	 * method declaration
	 */
	// add a new user
	public String add() {
		Date dNow = new Date();
		user.setUserDateOfRegister(dNow);
		user.setUserType("student");
		if (!user.getUserPassword().equals(user.getConfirmPassword())) {
			System.out.println("password and confirm password missmatch");
			addActionError("invalid registration");
			return "fail";
		}
		if (user.getPhotoFileName() != null) {

			try {
				ServletContext servletContext = ServletActionContext
						.getServletContext();
				String path = "../uploads";
				String filePath = servletContext.getRealPath(path);
				System.out.println("Server path:" + filePath);
				File fileToCreate = new File(filePath, user.getPhotoFileName());
				FileUtils.copyFile(user.getPhoto(), fileToCreate);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
				return INPUT;
			}

		}

		DB.save(user);
		userList = DB.list(User.class);
		return "success";
	}
	/*
	 * Register new Staff Member
	 */

	public String addStaff() {
		Date dNow = new Date();
		user.setUserDateOfRegister(dNow);
		user.setUserType("lecturer");
		if (!user.getUserPassword().equals(user.getConfirmPassword())) {
			System.out.println("password and confirm password missmatch");
			addActionError("invalid registration");
			return "fail";
		}
		if (user.getPhotoFileName() != null) {

			try {
				ServletContext servletContext = ServletActionContext
						.getServletContext();
				String path = "../uploads";
				String filePath = servletContext.getRealPath(path);
				System.out.println("Server path:" + filePath);
				File fileToCreate = new File(filePath, user.getPhotoFileName());
				FileUtils.copyFile(user.getPhoto(), fileToCreate);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
				return INPUT;
			}

		}

		DB.save(user);
		userList = DB.list(User.class);
		return "success";
	}

	public String delete() {
		DB.delete(user);
		userList = DB.list(User.class);
		return SUCCESS;
	}

	public String execute() {
		userList = DB.list(User.class);
		return SUCCESS;
	}

	public String getUserIndividual() {
		UserDAO dao = new UserDAO();
		individualUser = dao.getUser((String) sessionMap.get("userIdNo"));

		return "success";

	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

}
