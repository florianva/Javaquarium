package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.AquariumVO;
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
	private static final String SESSION_USER_AQUARIUM = "session_user_aquarium";
	public static final String SESSION_USER_NB_POISSON = "session_user_nb_poisson";

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final int userId = 1;// todo : update when user system will be OP

		final IAquariumService service = new AquariumService();
		service.addPoisson(userId, "toto");

		final AquariumVO aquarium = service.getAquarium(userId);

		request.getSession().setAttribute(SESSION_USER_AQUARIUM, aquarium);
		request.getSession().setAttribute(SESSION_USER_NB_POISSON, aquarium.getPoissons().size());

		return mapping.findForward(FW_SUCCESS);
	}

}