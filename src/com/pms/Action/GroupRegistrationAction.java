package com.pms.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Group;
import com.pms.model.Member;
import com.pms.model.User;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class GroupRegistrationAction extends ActionSupport implements SessionAware {
	
	/*
	 * private attributes
	 */
	private Group groups;
	private List<Group> members;
	private List<User> users;
	private GroupRegistrationDAO dao;
	private String GroupId;
	private String Leader;
	private String groupIdName;
	private String groupLeader;
	private Login login;
	private Map<String, Object> sessionMap;
	private List<String> userIds;
	private String memberOne;
	private String memberTwo;
	private String memberThree;
	private String leaderName;
	
	/*
	 *  Getters and setters
	 */
	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getMemberOne() {
		return memberOne;
	}

	public void setMemberOne(String memberOne) {
		this.memberOne = memberOne;
	}

	public String getMemberTwo() {
		return memberTwo;
	}

	public void setMemberTwo(String memberTwo) {
		this.memberTwo = memberTwo;
	}

	public String getMemberThree() {
		return memberThree;
	}

	public void setMemberThree(String memberThree) {
		this.memberThree = memberThree;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

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

	public Group getGroups() {
		return groups;
	}

	public void setGroups(Group groups) {
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

	public List<Group> getMembers() {
		return members;
	}

	public void setMembers(List<Group> members) {
		this.members = members;
	}
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	
	/*
	 * Action Methods
	 * this is default method in struts 2
	 * this will load the group list when user loged to home menu
	 */
	public String execute() {
		UserDAO daoUser = new UserDAO();
		User currentUser = daoUser.userAuthonticate(login);
		String userLoginName = currentUser.getUserName();
		String password = currentUser.getUserPassword();
		String userType = currentUser.getUserType();
		if (userType.equals("admin") || userType.equals("hod") || userType.equals("lecturerIncharge")) {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				sessionMap.put("userIdNo", login.getUserName());
				sessionMap.put("loggedUser", userLoginName);
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
				sessionMap.put("loggedUser", userLoginName);
				System.out.print((String)sessionMap.get("userIdNo"));
				groups = dao.getRegisteredGroups(login.getUserName());
				if (groups != null) {
					leaderName = dao.getLeader(groups.getLeaderId());
					System.out.println("leader name is " + dao.getLeader(groups.getLeaderId()));
					GroupId = groups.getGroupId();
				} else {
					this.setLeaderName("new");
					this.setGroupId("new");
				}
				return "success";
			} else {
				login.setLoginState("errorLogin");
				addActionError("invalid login");
				return "fail";
			}
		}
	}
	
	/*
	 * this method will load the all the groups
	 */
	public String loadGroups() {
		groups = dao.getRegisteredGroups(sessionMap.get("userIdNo").toString());
		leaderName = dao.getLeader(groups.getLeaderId());
		GroupId = groups.getGroupId();
		return "success";
	}

	/*
	 * this method will get all the members registerd
	 */
	public String getListMembers() {
		members = dao.getMembersIndividualGroup(this.groupIdName);
		return "success";
	}
	
	/*
	 * use to get registered members id with given group id
	 */
	public String getMembersId() {
		UserDAO dao = new UserDAO();
		userIds = new ArrayList<String>();
		users = dao.getStudentUsersId("student");
		for (int i=0; i<users.size(); i++){
			User iuser = new User();
			iuser = users.get(i);
			if (iuser.getUserIdNo().equals(sessionMap.get("userIdNo"))) {
				continue;
			}
			String userId = iuser.getUserIdNo();
			userIds.add(userId);
		}
		return "success";
	}
	
	/*
	 * this will add group to database
	 */
	public String addGroup() {
		System.out.println("Add group Action called");
		Group group = new Group();
		String result;
		
		GroupRegistrationDAO dao = new GroupRegistrationDAO();
		String count = dao.getCountOfRegisteredGroups();
		Integer idGenerate = Integer.parseInt(count) + 1;
		group.setGroupId(idGenerate.toString());
		group.setLeaderId((String)sessionMap.get("userIdNo"));
		group.setMemberId((String)sessionMap.get("userIdNo"));
		result = this.saveGroup(group);
		
		group.setLeaderId((String)sessionMap.get("userIdNo"));
		group.setMemberId(this.memberOne);
		result = this.saveGroup(group);
		
		group.setLeaderId((String)sessionMap.get("userIdNo"));
		group.setMemberId(this.memberTwo);
		result = this.saveGroup(group);
		
		group.setLeaderId((String)sessionMap.get("userIdNo"));
		group.setMemberId(this.memberThree);
		result = this.saveGroup(group);
		
		if(result.equals("success")) {
			this.loadGroups();
			return "success";
		}
		return "fail";
	}
	
	/*
	 * use to save member to database
	 */
	public String saveGroup(Group group) {
		boolean result = false;
		GroupRegistrationDAO dao = new GroupRegistrationDAO();
		result = dao.addMemberToGroup(group);
		return "success";
	}
	/*
	 * (non-Javadoc)
	 * create session object
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
