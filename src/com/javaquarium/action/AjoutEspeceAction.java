package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;

/**
 * Classic Action
 * 
 * @author Florian
 *
 */

public class AjoutEspeceAction extends Action {

	private IPoissonService poissonService;
	private static final String FW_SUCCESS = "success";
	private static final String FW_ERROR = "failed";

	/**
	 * 
	 */

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		final PoissonVO poissonForm = (PoissonVO) form;

		if (poissonService.isExist(poissonForm)) {
			poissonService.save(poissonForm);
			return mapping.findForward(FW_SUCCESS);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.newespece.nom.exist"));
			saveErrors(request, errors);
			return mapping.findForward(FW_ERROR);
		}
	}

	/**
	 * @param poissonService
	 *            the poissonService to set
	 */
	public void setPoissonService(IPoissonService poissonService) {
		this.poissonService = poissonService;
	}
}