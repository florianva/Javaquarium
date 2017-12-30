package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.AquariumService;
import com.javaquarium.business.IAquariumService;

/**
 * Classic Action
 * 
 * @author Geoffrey
 *
 */

public class AjoutPoissonDansAquariumAction extends Action {

	private static final String FW_SUCCESS = "success";
	public static final String SESSION_USER_NB_POISSON = "session_user_nb_poisson";

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final int userId = (int) request.getSession().getAttribute(LoginAction.SESSION_USER_ID);

		final IAquariumService service = new AquariumService();
		final PoissonUserVO aquarium = service.getAquarium(userId);
		final PoissonVO poisson = (PoissonVO) form;

		aquarium.getPoissons().add(poisson);

		service.addPoisson(aquarium, userId);

		request.getSession().setAttribute(SESSION_USER_NB_POISSON, aquarium.getPoissons().size());

		return mapping.findForward(FW_SUCCESS);
	}

}