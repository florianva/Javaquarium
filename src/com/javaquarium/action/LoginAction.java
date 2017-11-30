package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.LoginVO;

/**
 * Classic Action
 * 
 * @author Florian
 *
 */

public class LoginAction extends Action {

	private static final String FW_SUCCESS = "success";
	private static final String FW_FAILED = "failed";

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final LoginVO loginForm = (LoginVO) form;
		if (loginForm != null) {
			if (loginForm.getUser().equals(loginForm.getPassword())) {
				return mapping.findForward(FW_SUCCESS);
			} else {
				return mapping.findForward(FW_FAILED);
			}
		} else {
			return mapping.findForward(FW_FAILED);
		}
	}

}
