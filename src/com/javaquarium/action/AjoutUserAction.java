package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.ILoginService;

/**
 * Classic Action
 * 
 * @author Florian
 *
 */

public class AjoutUserAction extends Action {

	private ILoginService loginService;
	private static final String FW_SUCCESS = "success";
	private static final String FW_ERROR = "failed";

	/**
	 * 
	 */

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final LoginVO loginForm = (LoginVO) form;

		if (loginService.isExist(loginForm)) {
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.newlogin.user.exist"));
			saveErrors(request, errors);
			return mapping.findForward(FW_ERROR);
		} else {
			loginService.save(loginForm);
			return mapping.findForward(FW_SUCCESS);
		}
	}

	/**
	 * @param loginService
	 *            the loginService to set
	 */
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
}