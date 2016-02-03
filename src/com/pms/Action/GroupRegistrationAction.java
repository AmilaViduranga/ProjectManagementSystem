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
import com.pms.DAO.LectureInchargeDAO;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;

public class GroupRegistrationAction extends ActionSupport implements SessionAware {
	
	/*
	 * private attributes
	 */
	private Group groups;
	private List<Group> members;
	private List<User> users;
	private List<Group> registeredGroups;
	private GroupRegistrationDAO dao;
	private String GroupId;
	private String Leader;
	private String groupIdName;
	private String groupLeader;
	private Login login;
	private Map<String, Object> sessionMap;
	private List<String> userIds;
	private String memberLeader;
	private String memberOne;
	private String memberTwo;
	private String memberThree;
	private String leaderName;
	private String isLectureIncharge;
	/*
	 *  Getters and setters
	 */
	
	public String getIsLectureIncharge() {
		return isLectureIncharge;
	}

	public void setIsLectureIncharge(String isLectureIncharge) {
		this.isLectureIncharge = isLectureIncharge;
	}
	
	public String getLeaderName() {
		return leaderName;
	}

	public String getMemberLeader() {
		return memberLeader;
	}

	public void setMemberLeader(String memberLeader) {
		this.memberLeader = memberLeader;
	}

	public List<Group> getRegisteredGroups() {
		return registeredGroups;
	}

	public void setRegisteredGroups(List<Group> registeredGroups) {
		this.registeredGroups = registeredGroups;
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
		boolean isLectureIncharge = currentUser.getIsLecturerInCharge();
		if (userType.equals("admin") || userType.equals("hod") || userType.equals("lecturer")) {
			System.out.println("The current userType is "+userType);
			if (isLectureIncharge) {
				if (password.equals(login.getUserPassword())) {
					login.setLoginState("logged");
					sessionMap.put("userIdNo", login.getUserName());
					sessionMap.put("loggedUser", userLoginName);
					sessionMap.put("isLectureIncharge", "true");
					this.setIsLectureIncharge("true");
					LectureInchargeDAO lectureIncharge = new LectureInchargeDAO();
					registeredGroups = lectureIncharge.getAllRegisteredGroups();
					return "lectureIncharge";
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
					sessionMap.put("isLectureIncharge", "false");
					System.out.print(sessionMap.get("userIdNo"));
					return userType;
				} else {
					login.setLoginState("errorLogin");
					addActionError("invalid login");
					return "fail";
				}
			}
		} else {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				sessionMap.put("userIdNo", login.getUserName());
				sessionMap.put("loggedUser", userLoginName);
				sessionMap.put("isLectureIncharge", "false");
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
		this.setIsLectureIncharge("false");
		String isLectureIncharger = (String)sessionMap.get("isLectureIncharge");
		if (isLectureIncharger.equals("true")) {
			this.setIsLectureIncharge("true");
		}
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
		
		if (sessionMap.get("isLectureIncharge").equals("true")) {
			group.setLeaderId(this.memberLeader);
			group.setMemberId(this.memberLeader);
			result = this.saveGroup(group);
			
			group.setLeaderId(this.memberLeader);
			group.setMemberId(this.memberOne);
			result = this.saveGroup(group);
			
			group.setLeaderId(this.memberLeader);
			group.setMemberId(this.memberTwo);
			result = this.saveGroup(group);
			
			group.setLeaderId(this.memberLeader);
			group.setMemberId(this.memberThree);
			result = this.saveGroup(group);
		} else {
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
		}
		if(result.equals("success")) {
			if(sessionMap.get("isLectureIncharge").equals("true")) {
				this.getAllRegisteredGroups();
				return "isLectureIncharge";
			}
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
	
	public String getAllRegisteredGroups() {
		LectureInchargeDAO dao = new LectureInchargeDAO();
		registeredGroups = dao.getAllRegisteredGroups();
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
