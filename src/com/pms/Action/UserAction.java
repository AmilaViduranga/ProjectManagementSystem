package com.pms.Action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;

import org.apache.catalina.Session;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.pms.DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pms.model.Cv;
import com.pms.model.Login;
import com.pms.model.User;
import com.pms.util.DB;
import com.pms.util.EmailUtility;

public class UserAction extends ActionSupport implements SessionAware {

	/**
	 * This class has Action related to User
	 * @author pasindu lakmal
	 *
	 */
	private Map<String, Object> sessionMap;
	private User user;
	private List userList;
	private Login login;
	private User individualUser;
	private String userIdNo;
	private String userEmail;
	private String userpssword;
	private String userNewPssword;
	private String userConfirmNewPassword;
	private String profilePassword;
	private Cv cv;
	private String nowUser;
	private User photoUser;
	
//	private File document;
//	private String documentFileName;
//	private String documentContentType;
	
	
	

	/**
	 * Getters and Setters for private attributes
	 */
	
	

	
	
	public User getUser() {
		return user;
	}
	public User getPhotoUser() {
		return photoUser;
	}
	public void setPhotoUser(User photoUser) {
		this.photoUser = photoUser;
	}
	public String getNowUser() {
		return nowUser;
	}
	public void setNowUser(String nowUser) {
		this.nowUser = nowUser;
	}
	public Cv getCv() {
		return cv;
	}
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	


	public String getUserIdNo() {
		return userIdNo;
	}

	public void setUserIdNo(String userIdNo) {
		this.userIdNo = userIdNo;
	}

	public String getProfilePassword() {
		return profilePassword;
	}

	public void setProfilePassword(String profilePassword) {
		this.profilePassword = profilePassword;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserpssword() {
		return userpssword;
	}

	public void setUserpssword(String userpssword) {
		this.userpssword = userpssword;
	}

	public String getUserNewPssword() {
		return userNewPssword;
	}

	public void setUserNewPssword(String userNewPssword) {
		this.userNewPssword = userNewPssword;
	}

	public String getUserConfirmNewPassword() {
		return userConfirmNewPassword;
	}

	public void setUserConfirmNewPassword(String userConfirmNewPassword) {
		this.userConfirmNewPassword = userConfirmNewPassword;
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

	/**
	 * This method is use for add new student to system
	 * 
	 * @see insert new student to system
	 */

	public String add() throws AddressException, MessagingException {
		/*
		 *  set properties related to student
		 */
		Date dNow = new Date();
		user.setUserDateOfRegister(dNow);
		user.setGroupRegisteredState("notRegistered");
		user.setIsLecturerInCharge(false);
		user.setUserType("student");
		/*
		 * check password and confirm password
		 */
		if (!user.getUserPassword().equals(user.getConfirmPassword())) {
			System.out.println("password and confirm password missmatch");
			addActionError("invalid registration");
			return "fail";
		}
		/*
		 * check User ID available
		 */
		String inputName = user.getUserIdNo();
		UserDAO dao = new UserDAO();
		Boolean hasName = dao.cheakUserAvailablity(inputName);
		if (hasName) {
			addActionError("invalid registration");
			
			return "fail";
		}
		/*
		 * check User Email available
		 */
		String inputemail = user.getUserEmail();
		System.out.println("inputemail  "+inputemail);
		UserDAO obj = new UserDAO();
		Boolean hasEmail = obj.cheakUserEmailAvailablity(inputemail);
		if (hasEmail) {
			addActionMessage("invalid registration");
			
			return "fail";
		} 
		/*
		 * check User photo available
		 */
		
		if (user.getPhotoFileName() != null) {

			try {
				ServletContext servletContext = ServletActionContext
						.getServletContext();
				String path = "/uploads/";
				String filePath = servletContext.getRealPath(path);
				System.out.println("Server path:" + filePath);
				File fileToCreate = new File(filePath, user.getPhotoFileName());
				FileUtils.copyFile(user.getPhoto(), fileToCreate);
			} catch (Exception e) {
				e.printStackTrace();
				
				return INPUT;
			}

		}
		/*
		 * sending email to student email
		 */
		String sender = user.getUserEmail();
		String eMessageHeader = "Registration PMS";
		String eMessage = "you Sucessfully registered with Sliit Project Management System";

		EmailUtility.sendEmail("smtp.gmail.com", "587",
				"pasindulakmal1012@gmail.com", "lion@1234", sender,
				eMessageHeader, eMessage); 
		/*
		 * save student
		 */
		DB.save(user);
		addActionMessage("Registered Successfully");
		userList = DB.list(User.class);
		return "success";
	}

	/**
	 * This method is use for inser new staff member to the system
	 * 
	 * @see add new staff mwmber to system
	 */

	public String addStaff() {
		Date dNow = new Date();
		user.setUserDateOfRegister(dNow);
		user.setUserType("lecturer");
		user.setIsLecturerInCharge(false);
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
		/*
		 * save user
		 */
		DB.save(user);
		userList = DB.list(User.class);
		return "success";
	}

	/**
	 * This method is use for update user profile
	 * 
	 * @see update user information in user profile
	 */

	public String updateUserProfile() {
		/*
		 * get saved user
		 */
		UserDAO dao = new UserDAO();
		User savedUser = dao.getUser(user.getUserIdNo());
		/*
		 * password checking
		 */
		if (savedUser.getUserPassword().equals(profilePassword)) {
			/*
			 * check new photo available
			 */
			if (user.getPhotoFileName() != null) {

				try {
					ServletContext servletContext = ServletActionContext
							.getServletContext();
					String path = "/uploads/";
					String filePath = servletContext.getRealPath(path);
					System.out.println("Server path:" + filePath);
					File fileToCreate = new File(filePath,
							user.getPhotoFileName());
					FileUtils.copyFile(user.getPhoto(), fileToCreate);
				} catch (Exception e) {
					e.printStackTrace();
					addActionError(e.getMessage());
					return INPUT;
				}
				/*
				 * update photo
				 */
				savedUser.setPhoto(user.getPhoto());
				savedUser.setPhotoContentType(user.getPhotoContentType());
				savedUser.setPhotoFileName(user.getPhotoFileName());

			}
			/*
			 * check password changing
			 */
			if (!userNewPssword.equals("")
					&& !userConfirmNewPassword.equals("")) {

				savedUser.setUserPassword(userNewPssword);

			}
			/*
			 * save email
			 */
			savedUser.setUserEmail(user.getUserEmail());
			/*
			 * update user with new details
			 */
			
			DB.update(savedUser);
			return SUCCESS;
		}
		/*
		 * password mismatched add error
		 */
		addActionError("password mismatch");
		return "fail";

	}

	/**
	 * This menthod is use to delete anyuser from user
	 * 
	 * @see delete user
	 */
	public String delete() {
		DB.delete(user);
		userList = DB.list(User.class);
		return SUCCESS;
	}

	public String execute() {
		userList = DB.list(User.class);
		return SUCCESS;
	}

	/**
	 * This method is use for get current user from session
	 * 
	 * @see current logging user
	 */

	public String getUserIndividual() {
		/*
		 * create dao
		 */
		UserDAO dao = new UserDAO();
		System.out.println((String) sessionMap.get("userIdNo"));
		System.out.println("action called");
		/*
		 * get current user using ID
		 */
		individualUser = dao.getUser((String) sessionMap.get("userIdNo"));
		return "success";
	}
	
	
	public String insertCv(){
		
		System.out.println("this is insert CV");
		System.out.println("document"+cv.getDocument());
		System.out.println("File name"+cv.getDocumentFileName());
		System.out.println("content type"+cv.getDocumentContentType());
		
		if (cv.getDocumentFileName() != null) {

			try {
				ServletContext servletContext = ServletActionContext
						.getServletContext();
				String path = "/uploads/";
				String filePath = servletContext.getRealPath(path);
				System.out.println("Server path:" + filePath);
				File fileToCreate = new File(filePath,
						cv.getDocumentFileName());
				FileUtils.copyFile(cv.getDocument(), fileToCreate);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
				return INPUT;
			}
			/*
			 * Insert CV
			 */
			cv.setDocument(cv.getDocument());
			cv.setDocumentContentType(cv.getDocumentContentType());
			cv.setDocumentFileName(cv.getDocumentFileName());
			System.out.println("this is cv object"+cv);
			System.out.println("this is user now "+nowUser);
			UserDAO userDao = new UserDAO();
			photoUser = userDao.getUser(nowUser);
			if(photoUser.getCv()!=null)
			DB.save(cv);
			System.out.println("photo user is"+photoUser);
			photoUser.setCv(cv);
			DB.update(photoUser);
			addActionMessage("success");

		}		
		return "success";
	}
	

	/**
	 * This method come up with framework it will inject a map of session
	 * attributes via the method.
	 * 
	 * @param Map<String,Object> Map for String and User object
	 * 
	 * @see use this map to add/remove attributes to/from the session.
	 */

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

}
