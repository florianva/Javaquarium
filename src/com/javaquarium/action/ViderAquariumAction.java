package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.business.IAquariumService;

/**
 * Classic Action
 * 
 * @author Geoffrey
 *
 */

public class ViderAquariumAction extends Action {

	private static final String FW_SUCCESS = "success";

	private IAquariumService aquariumService;

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final int userId = (int) request.getSession().getAttribute(LoginAction.SESSION_USER_ID);

		aquariumService.clean(userId);

		final PoissonUserVO aquarium = aquariumService.getAquarium(userId);

		request.getSession().setAttribute(AjoutPoissonDansAquariumAction.SESSION_USER_NB_POISSON,
				aquarium.getPoissons().size());

		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * @param aquariumService
	 *            the aquariumService to set
	 */
	public void setAquariumService(IAquariumService aquariumService) {
		this.aquariumService = aquariumService;
	}

}