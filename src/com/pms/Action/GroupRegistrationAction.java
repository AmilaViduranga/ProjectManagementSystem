package com.pms.Action;

import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Member;
import com.pms.model.User;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class GroupRegistrationAction extends ActionSupport implements SessionAware {
	private List<Member> groups;
	private List<Member> members;
	private GroupRegistrationDAO dao;
	private String GroupId;
	private String Leader;
	private String groupIdName;
	private String groupLeader;
	private Login login;
	private Map<String, Object> sessionMap;
	
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
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
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
				sessionMap.put("userIdNo", login.getUserName());
				System.out.print(sessionMap.get("userIdNo"));
				return userType;

			} else {
				login.setLoginState("errorLogin");
				addActionError("invalid login");
				return "fail";
			}
		} else {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				sessionMap.put("userIdNo", login.getUserName());
				System.out.print((String)sessionMap.get("userIdNo"));
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
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
}
