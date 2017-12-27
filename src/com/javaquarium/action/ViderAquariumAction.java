package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.business.AquariumService;
import com.javaquarium.business.IAquariumService;

/**
 * Classic Action
 * 
 * @author Geoffrey
 *
 */

public class ViderAquariumAction extends Action {

	private static final String FW_SUCCESS = "success";

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final int userId = 1;// todo : update when user system will be OP
		final IAquariumService service = new AquariumService();

		service.clean(userId);

		final PoissonUserVO aquarium = service.getAquarium(userId);

		request.getSession().setAttribute(AjoutPoissonDansAquariumAction.SESSION_USER_NB_POISSON,
				aquarium.getPoissons().size());

		return mapping.findForward(FW_SUCCESS);
	}

}