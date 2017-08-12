package com.arjun.info.arjuninfo;

import java.io.Serializable;

public class EmailModle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userEmail;
	private String message;
	private String subject;

	@Override
	public String toString() {
		return "EmailModle [userName=" + userName + ", userEmail=" + userEmail + ", message=" + message + ", subject="
				+ subject + "]";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
