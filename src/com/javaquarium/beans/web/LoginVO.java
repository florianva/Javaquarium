package com.javaquarium.beans.web;

import org.apache.struts.action.ActionForm;

public class LoginVO extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7206026725526887388L;
	private String user;
	private String password;

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
