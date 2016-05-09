package com.pms.Action;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.pms.util.EmailUtility;


public class SendEmailAction {
	
	/**
	 * This class is use to sent email
	 * @author pasindu lakmal
	 *
	 */

	// SMTP properties - fetched from struts.xml
	private String host;
	private String port;
	private String userName;
	private String password;


	// e-mail fields - fetched from EmailForm.jsp
	private String recipient="topasindul@gmail.com";
	private String subject="test";
	private String message="test";

	public String doSendEmail() throws IOException, AddressException, MessagingException {
		

		EmailUtility.sendEmail(host, port, userName, password, recipient,
				subject, message);

		
		return "success";
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}