package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.AquariumVO;
import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.AquariumService;
import com.javaquarium.business.IAquariumService;

/**
 * Classic Action
 * 
 * @author Florian
 *
 */

public class LoginAction extends Action {

	private static final String FW_SUCCESS = "success";
	private static final String FW_FAILED = "failed";
	public static final String SESSION_USER_NAME = "user_name";

	private IAquariumService serviceAquarium;

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		serviceAquarium = new AquariumService();

		final LoginVO loginForm = (LoginVO) form;
		final AquariumVO aquarium = serviceAquarium.getAquarium(1); // todo : update when user system will be OP

		if (loginForm != null) {
			if (loginForm.getUser().equals(loginForm.getPassword())) {
				request.getSession().setAttribute(SESSION_USER_NAME, loginForm.getUser());
				request.getSession().setAttribute(AjoutPoissonDansAquariumAction.SESSION_USER_NB_POISSON,
						aquarium.getPoissons().size());

				return mapping.findForward(FW_SUCCESS);
			} else {
				return mapping.findForward(FW_FAILED);
			}
		} else {
			return mapping.findForward(FW_FAILED);
		}
	}

}
