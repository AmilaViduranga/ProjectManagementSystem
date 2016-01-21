package com.pms.Action;

import java.util.List;
import com.pms.model.Member;
import com.pms.DAO.GroupRegistrationDAO;;
public class GroupRegistrationAction {
	private List<Member> groups;
	private GroupRegistrationDAO dao;
	public List<Member> getGroups() {
		return groups;
	}

	public void setGroups(List<Member> groups) {
		this.groups = groups;
	}

	public GroupRegistrationDAO getDao() {
		return dao;
	}

	public void setDao(GroupRegistrationDAO dao) {
		this.dao = dao;
	}
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public GroupRegistrationAction() {
		dao = new GroupRegistrationDAO();
	}
	public String execute() {
		System.out.println("Execute run");
		groups = dao.getRegisteredGroups();
		System.out.println(groups);
		return "success";
	}

	
}
