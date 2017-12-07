package com.javaquarium.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginVO extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7206026725526887388L;
	private String user;
	private String password;

	public LoginVO() {
		user = new String();
		password = new String();
	}

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

	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		if (getPassword() != null) {
			if (getPassword().length() >= 4)
				return super.validate(mapping, request);
			else {
				ActionErrors errors = new ActionErrors();
				errors.add("error", new ActionMessage("error.password"));

				return errors;
			}
		}
		return new ActionErrors();
	}

}
