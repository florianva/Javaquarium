package com.javaquarium.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;

/**
 * Classic Action
 * 
 * @author Florian
 *
 */

public class ListerEspeceAction extends Action {

	private IPoissonService poissonService;
	private static final String FW_SUCCESS = "success";
	public static final String SESSION_LIST_POISSON = "LISTE_POISSON";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final List<PoissonVO> listePoissons = poissonService.getAll();

		request.getSession().setAttribute(SESSION_LIST_POISSON, listePoissons);

		return mapping.findForward(FW_SUCCESS);

	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setPoissonService(IPoissonService poissonService) {
		this.poissonService = poissonService;
	}
}
