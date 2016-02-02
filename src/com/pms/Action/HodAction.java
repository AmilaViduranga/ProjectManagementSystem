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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Object Declaration
	 */
	private List<User> groups;
	private List<User> lecturers;
	private String userName;
	private Map<String, Object> sessionMap;
	private List<String> lecturesNames;
	private String selectedName;
	private User selectedLectureInCharge;
	private User previousLectureInCharge;

	/*
	 * Method Declaration
	 */

	/*
	 * Getters and Setters
	 */

	public List<User> getGroups() {
		return groups;
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

	public String getAllLecturers() {

		System.out.println("call HOD Action  now");
		HodDAO dao = new HodDAO();
		lecturers = dao.getLectursByType();
		System.out.println(lecturers);
		return "success";
	}

	public String getLecturesByNames() {
		HodDAO dao = new HodDAO();
		lecturers = dao.getLectursByType();
		lecturesNames = new ArrayList<String>();
		for (int i = 0; i < lecturers.size(); i++) {
			User user = new User();
			user = lecturers.get(i);
			lecturesNames.add(user.getUserName());
		}
		System.out.println("Lecture name are" + lecturesNames);
		return "success";
	}

	public String saveLectureInCharge() {

		System.out.println("---this is save lecture in charge-----");
		System.out.println(">>>" + selectedName);

		HodDAO dao = new HodDAO();
		previousLectureInCharge = dao.getPreviousLecInCharge();
		System.out.println(">>>previousLectureInCharge"
				+ previousLectureInCharge);
		previousLectureInCharge.setIsLecturerInCharge(false);
		DB.update(previousLectureInCharge);
		selectedLectureInCharge = dao.getUserByName(selectedName);
		System.out.println(">>>selectedLectureInCharge"
				+ selectedLectureInCharge);
		selectedLectureInCharge.setIsLecturerInCharge(true);
		DB.update(selectedLectureInCharge);

		return "success";
	}

	/*
	 * Get Current Session
	 */

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.sessionMap = sessionMap;

	}

}
