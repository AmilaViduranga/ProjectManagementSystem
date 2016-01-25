package com.pms.Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Member;
import com.pms.model.User;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class GroupRegistrationAction extends ActionSupport {
	private List<Member> groups;
	private List<Member> members;
	private GroupRegistrationDAO dao;
	private String GroupId;
	private String Leader;
	private String groupIdName;
	private String groupLeader;
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}

	public String getGroupIdName() {
		return groupIdName;
	}

	public void setGroupIdName(String id) {
		this.groupIdName = id;
	}

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	public String getLeader() {
		return Leader;
	}

	public void setLeader(String leader) {
		Leader = leader;
	}

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

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	// methods Action
	public String execute() {
		UserDAO daoUser = new UserDAO();
		User currentUser = daoUser.userAuthonticate(login);
		String password = currentUser.getUserPassword();
		String userType = currentUser.getUserType();
		if (userType.equals("admin") || userType.equals("hod") || userType.equals("lecturerIncharge")) {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				return userType;

			} else {
				login.setLoginState("errorLogin");
				addActionError("invalid login");
				return "fail";
			}
		} else {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				groups = dao.getRegisteredGroups();
				return "success";

			} else {
				login.setLoginState("errorLogin");
				addActionError("invalid login");
				return "fail";
			}
		}
	}

	public String loadGroups() {
		groups = dao.getRegisteredGroups();
		System.out.println(groups);
		return "success";

	}

	public String getListMembers() {
		System.out.println("call Action now");
		members = dao.getMembersIndividualGroup(this.groupIdName);
		System.out.println(members);
		return "success";
	}

}
