package com.pms.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.HodDAO;
import com.pms.model.User;
import com.pms.util.DB;

public class HodAction extends ActionSupport implements SessionAware {

	/**
	 * This class is use for handle actions doing by HOD
	 */

	/**
	 * Object Declaration
	 */
	private static final long serialVersionUID = 1L;
	private List<User> groups;
	private List<User> lecturers;
	private String userName;
	private Map<String, Object> sessionMap;
	private List<String> lecturesNames;
	private String selectedName;
	private User selectedLectureInCharge;
	private User previousLectureInCharge;
	private List licState;

	/**
	 * Getters and Setters
	 */

	public List<User> getGroups() {
		return groups;
	}

	public List getLicState() {
		return licState;
	}

	public void setLicState(List licState) {
		this.licState = licState;
	}

	public User getPreviousLectureInCharge() {
		return previousLectureInCharge;
	}

	public void setPreviousLectureInCharge(User previousLectureInCharge) {
		this.previousLectureInCharge = previousLectureInCharge;
	}

	public User getSelectedLectureInCharge() {
		return selectedLectureInCharge;
	}

	public void setSelectedLectureInCharge(User selectedLectureInCharge) {
		this.selectedLectureInCharge = selectedLectureInCharge;
	}

	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public List<String> getLecturesNames() {
		return lecturesNames;
	}

	public void setLecturesNames(List<String> lecturesNames) {
		this.lecturesNames = lecturesNames;
	}

	public void setGroups(List<User> groups) {
		this.groups = groups;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<User> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<User> lecturers) {
		this.lecturers = lecturers;
	}

	/**
	 * This method is use for get all lectures
	 * 
	 * @see lectuerers object with currernt lectures
	 * @return success
	 */
	public String getAllLecturers() {
		/*
		 * creating object from HodAdo class
		 */
		HodDAO dao = new HodDAO();
		/*
		 * get all lectures using type
		 */
		lecturers = dao.getLectursByType();
		System.out.println(lecturers);
		return "success";
	}

	/**
	 * This method is use for get all lectures by their name
	 * 
	 * @see lectuer in charge
	 * @return success
	 */
	public String getLecturesByNames() {
		/*
		 * creating object from HodDAO class
		 */
		HodDAO dao = new HodDAO();
		/*
		 * get all lectures using type
		 */
		lecturers = dao.getLectursByType();
		/*
		 * get all lectures names
		 */
		lecturesNames = new ArrayList<String>();
		for (int i = 0; i < lecturers.size(); i++) {
			User user = new User();
			user = lecturers.get(i);
			lecturesNames.add(user.getUserName());
		}
		System.out.println("Lecture name are" + lecturesNames);
		return "success";
	}

	/**
	 * This method is use for save lecture in charge
	 * 
	 * @see lectuerers names
	 * @return success
	 */

	public String saveLectureInCharge() {
		/*
		 * creating object from HodDAO class
		 */
		HodDAO dao = new HodDAO();
		/*
		 * check lecture in charge state is empty in initially in the first
		 * appointment of lecture in charge
		 */
		licState = dao.getStateOfLic();
		/*
		 * remove previous lecture in charge
		 */
		if (!licState.isEmpty()) {
			previousLectureInCharge = dao.getPreviousLecInCharge();
			System.out.println(">>>previousLectureInCharge"
					+ previousLectureInCharge);
			previousLectureInCharge.setIsLecturerInCharge(false);
			DB.update(previousLectureInCharge);
		}
		/*
		 * set new lecture in charge
		 */
		selectedLectureInCharge = dao.getUserByName(selectedName);
		System.out.println(">>>selectedLectureInCharge"
				+ selectedLectureInCharge);
		selectedLectureInCharge.setIsLecturerInCharge(true);
		DB.update(selectedLectureInCharge);

		return "success";
	}

	/**
	 * This method come up with framework it will inject a map of session
	 * attributes via the method.
	 * 
	 * @param Map<String,Object> Map for String and User object 
	 * @see use this map to add/remove attributes to/from the session.
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {

		this.sessionMap = sessionMap;

	}

}
