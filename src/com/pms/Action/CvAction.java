package com.pms.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pms.DAO.CvDAO;
import com.pms.model.Cv;
import com.pms.model.User;

public class CvAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> studentUsers;
	private User student;
	private String docName;

	private InputStream inputStream;
	private String fileName;
	private long contentLength;
	
	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<User> getStudentUsers() {
		return studentUsers;
	}

	public void setStudentUsers(List<User> studentUsers) {
		this.studentUsers = studentUsers;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public String loadStudent() {

		System.out.println("CV Action called");
		CvDAO dao = new CvDAO();
		studentUsers = dao.getStudentByType();
		System.out.println("this is student2" + studentUsers);
		return "success";

	}

	public String downloadCv() throws FileNotFoundException {	
		
		System.out.println("docFileName  "+docName);
		
		
		File fileToDownload = new File("C:/Users/pasindu/git/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ProjectManagementSystem/uploads/"+docName+"");
		System.out.println("file to download  "+fileToDownload);
		System.out.println("file to download name  "+fileToDownload.getName());
		inputStream = new FileInputStream(fileToDownload);
		fileName = fileToDownload.getName();
		contentLength = fileToDownload.length();
		
		return SUCCESS;
		
	}

}
