package com.pms.Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.model.Group;
import com.pms.model.Member;
import com.pms.model.Project;
import com.pms.model.User;
import com.pms.DAO.DbConnectionManager;
import com.pms.DAO.GroupRegistrationDAO;
import com.pms.DAO.LectureInchargeDAO;
import com.pms.DAO.ProjectDAO;
import com.pms.DAO.UserDAO;
import com.pms.model.Login;
import com.pms.util.DB;
import com.pms.util.EmailUtility;

/**
 * this class handle the login and group management tasks
 */
public class GroupRegistrationAction extends ActionSupport implements SessionAware {
	
	/**
	 * private attributes
	 */
	private Member member;
	private Group groups;
	private GroupRegistrationDAO dao;
	private String GroupId;
	private String Leader;
	private String groupIdName;
	private String groupLeader;
	private Login login;
	private String memberLeader;
	private String memberOne;
	private String memberTwo;
	private String memberThree;
	private String leaderName;
	private String isLectureIncharge;
	private List<Project> submittedProjectList;
	private List<Group> members;
	private List<User> users;
	private List<Group> registeredGroups;
	private List<String> userIds;
	private Map<String, Object> sessionMap;
	private List<User> individualMembers;
	private User photoUser;
	private String projectId;
	private Group mem;
	private String acceptState;
	private List<Project> allProjects;
	
	/**
	 *  Getters and setters
	 */
	
	
	
	public String getIsLectureIncharge() {
		return isLectureIncharge;
	}

	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}

	public Group getMem() {
		return mem;
	}

	public void setMem(Group mem) {
		this.mem = mem;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<User> getIndividualMembers() {
		return individualMembers;
	}

	public void setIndividualMembers(List<User> individualMembers) {
		this.individualMembers = individualMembers;
	}

	public User getPhotoUser() {
		return photoUser;
	}

	public void setPhotoUser(User photoUser) {
		this.photoUser = photoUser;
	}

	public List<Project> getSubmittedProjectList() {
		return submittedProjectList;
	}

	public void setSubmittedProjectList(List<Project> submittedProjectList) {
		this.submittedProjectList = submittedProjectList;
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

	
	/**
	 * Action Methods
	 * this is default method in struts 2
	 * this will load the group list when user loged to home menu and this will
	 * user authontications user permissions and initial things in this application
	 * will handle this function
	 */
	public String execute() {
		UserDAO daoUser = new UserDAO();
		User currentUser = new User();
		if (sessionMap.get("login") != null) {
			login = (Login)sessionMap.get("login");
		} 
		currentUser = daoUser.userAuthonticate(login);
		photoUser = currentUser;
		sessionMap.put("userPhoto", photoUser);
		String userLoginName = currentUser.getUserName();
		String password = currentUser.getUserPassword();
		String userType = currentUser.getUserType();
		boolean isLectureIncharge = currentUser.getIsLecturerInCharge();
		sessionMap.put("userIdNo", login.getUserName());
		sessionMap.put("loggedUser", userLoginName);
		sessionMap.put("login", login);
		if (userType.equals("admin") || userType.equals("hod") || userType.equals("lecturer")) {
			if (isLectureIncharge) {
				if (password.equals(login.getUserPassword())) {
					login.setLoginState("logged");
					sessionMap.put("isLectureIncharge", "true");
					sessionMap.put("userType","lectureIncharge");
					this.setIsLectureIncharge("true");
					LectureInchargeDAO lectureIncharge = new LectureInchargeDAO();
					registeredGroups = lectureIncharge.getAllRegisteredGroups();
					return "lectureIncharge";
				} else {
					login.setLoginState("errorLogin");
					addActionError("invalid login");
					sessionMap.clear();
					return "fail";
				}
			} else {
				if (userType.equals("lecturer")) {
					if (password.equals(login.getUserPassword())) {
						login.setLoginState("logged");
						sessionMap.put("isLectureIncharge", "false");
						sessionMap.put("userType", userType);
						this.getAllProjects();
						return userType;
					} else {
						login.setLoginState("errorLogin");
						addActionError("invalid login");
						sessionMap.clear();
						return "fail";
					}
				}
				if (password.equals(login.getUserPassword())) {
					login.setLoginState("logged");
					sessionMap.put("isLectureIncharge", "false");
					sessionMap.put("userType", userType);
					return userType;
				} else {
					login.setLoginState("errorLogin");
					addActionError("invalid login");
					sessionMap.clear();
					return "fail";
				}
			}
		} else {
			if (password.equals(login.getUserPassword())) {
				login.setLoginState("logged");
				sessionMap.put("isLectureIncharge", "false");
				sessionMap.put("userType", userType);
				GroupRegistrationDAO dao = new GroupRegistrationDAO();
				boolean isLeader = dao.isLeaderLogedIn((String)sessionMap.get("userIdNo"));
				if (isLeader) {
					sessionMap.put("isLeader", "leader");
				}
				groups = dao.getRegisteredGroups(login.getUserName());
				if (groups != null) {
					leaderName = dao.getLeader(groups.getLeaderId());
					GroupId = groups.getGroupId();
					sessionMap.put("groupIdExcist", GroupId);
				} else {
					this.setLeaderName("new");
					this.setGroupId("new");
					sessionMap.put("groupIdExcist", "new");
				}
				return "success";
			} else {
				login.setLoginState("errorLogin");
				addActionError("invalid login");
				sessionMap.clear();
				return "fail";
			}
		}
	}
	
	/**
	 * this method will load the  the group that particular user excist
	 */
	public String loadGroups() {
		groups = dao.getRegisteredGroups(sessionMap.get("userIdNo").toString());
		if (groups != null) {
			leaderName = dao.getLeader(groups.getLeaderId());
			GroupId = groups.getGroupId();	
		}
		return "success";
	}

	/**
	 * this method will get all the members registerd
	 */
	public String getListMembers() {
		members = dao.getMembersIndividualGroup(this.groupIdName);
		mem = members.get(0);
		projectId = mem.getProjectId();
		individualMembers = new ArrayList<User>();
		for(int i=0; i<members.size(); i++) {
			UserDAO userDao = new UserDAO();
			Group member = members.get(i);
			User user = userDao.getUser(member.getMemberId());
			individualMembers.add(user);
		}
			return "success";
		}
		
	/**
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
	
	/**
	 * this will handle the group registration
	 */
	public String addGroup() {
		Group group = new Group();
		String result;
		sessionMap.put("groupIdExcist","added");
		GroupRegistrationDAO dao = new GroupRegistrationDAO();
		String count = dao.getCountOfRegisteredGroups();
		Integer idGenerate = Integer.parseInt(count) + 1;
		group.setGroupId(idGenerate.toString());
		group.setProjectId("notSelected");
		group.setProjectComment("notSelected");
		group.setTechnology("notSelected");
		group.setLectureInchargeStatus("notSelected");
	
		
		/*
		 * this handle group assigning for lecture incharge
		 */
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
		} 
		/**
		 * this handle group registration for a student
		 */
		else {
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
	
	/**
	 * use to save groups to the data base
	 */
	public String saveGroup(Group group) {
		boolean result = false;
		GroupRegistrationDAO dao = new GroupRegistrationDAO();
		result = dao.addMemberToGroup(group);
		return "success";
	}
	
	/**
	 * get All the registered groups
	 */
	public String getAllRegisteredGroups() {
		LectureInchargeDAO dao = new LectureInchargeDAO();
		registeredGroups = dao.getAllRegisteredGroups();
		return "success";
	}
	
	/**
	 * get all projects
	 */
	public String getAllProjects() {
		ProjectDAO dao = new ProjectDAO();
		System.out.println((String)sessionMap.get("userIdNo"));
		submittedProjectList = dao.getSubmittedProject((String)sessionMap.get("userIdNo"));
		return "success";
	}
	
	public String getAllProjectsLI() {
		ProjectDAO dao = new ProjectDAO();
		System.out.println((String)sessionMap.get("userIdNo"));
		allProjects = dao.getAllProject();
		return "success";
	}
	
	/**
	 * (non-Javadoc)
	 * create session object
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	/**
	 * Log out from system
	 */
	public String logOut() {
		sessionMap.clear();
		return "success";
	}
	
	/**
	 * forget password
	 */
	public String forgetPassword() {
		UserDAO daoUser = new UserDAO();
		User currentUser = daoUser.userAuthonticate(login);
		String userEmail = currentUser.getUserEmail();
		String userPass = currentUser.getUserPassword();
		try {
			EmailUtility.sendEmail("smtp.gmail.com", "587", "pasindulakmal1012@gmail.com","lion@1234",userEmail, "Your password to PMS", "Your email password is "+userPass);
			addActionMessage("Check your email and try to log again");
		} catch(Exception e) {
			e.printStackTrace();
			addActionError("Server error, please wait");
		}
		this.getAllProjectsLI();
		return "success";
	}
	
	/**
	 *@author pasindu 
	 * 
	 */
	
	public String acceptProjectForSelectedGroup(){
		
		System.out.println("*****this is accept project for selected groups*****");
		System.out.println("this is group id"+groupIdName);
		System.out.println("this is state"+acceptState);
		
		GroupRegistrationDAO dao = new GroupRegistrationDAO();
		List<Group> group = new ArrayList<Group>();
		group = dao.getGroupSeperately(groupIdName);
		System.out.println("this is group"+group);
			if(acceptState.equals("accept")){
				for (Group singleGroup : group) {
					singleGroup.setLectureInchargeStatus("Accepted");
					DB.update(singleGroup);
				}
			}
			else{
				for (Group singleGroup : group) {
					singleGroup.setLectureInchargeStatus("notAccepted");
					DB.update(singleGroup);
				}
			}
		
		return "success";
	}
	
	
}
