package com.pms.Action;

import java.util.Date;
import java.util.List;
import javafx.scene.control.DatePicker;
import jdk.nashorn.internal.parser.DateParser;
import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;
import com.pms.model.User;
import com.pms.util.DB;


public class UserAction extends ActionSupport{
	/*
	 * Action class for user
	 */
	//declaring variables
	private User user;
	private List userList;
	private Login login;
	
	/*
	 * Getters and Setters for private attributes
	 */
	public User getUser() {
		return user;
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
	
	/*
	 * method declaration
	 */
	//add a new user
	public String add(){
		Date dNow = new Date();
		user.setUserDateOfRegister(dNow);
		DB.save(user);
		userList = DB.list(User.class);
		return "success";
	}
	public String delete(){
		DB.delete(user);
		userList = DB.list(User.class);
		return SUCCESS;
	}
	public String execute(){
		userList = DB.list(User.class);
		return SUCCESS;
	}
				
}
