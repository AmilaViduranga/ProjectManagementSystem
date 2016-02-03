package com.pms.Action;

import java.util.List;

import com.pms.DAO.LectureInchargeDAO;
import com.pms.model.Group;

public class LectureInchargeAction {
	private List<Group> registeredGroups;
	
	
	public List<Group> getRegisteredGroups() {
		return registeredGroups;
	}


	public void setRegisteredGroups(List<Group> registeredGroups) {
		this.registeredGroups = registeredGroups;
	}


	public String getAllRegisteredGroups() {
		LectureInchargeDAO dao = new LectureInchargeDAO();
		registeredGroups = dao.getAllRegisteredGroups();
		System.out.println("Registered groups at action"+registeredGroups);
		return "success";
	}
}
