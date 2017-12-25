package com.javaquarium.beans.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

/**
 * Classic Bean
 * 
 * @author Geoffrey
 *
 */
public class PoissonUserVO extends ActionForm {

	private static final long serialVersionUID = -2663549144418124947L;

	private List<PoissonVO> poissons;

	public PoissonUserVO() {
		this.setPoissons(new ArrayList<PoissonVO>());
	}

	/**
	 * @return the poissons
	 */
	public List<PoissonVO> getPoissons() {
		return poissons;
	}

	/**
	 * @param poissons
	 *            the poissons to set
	 */
	public void setPoissons(List<PoissonVO> poissons) {
		this.poissons = poissons;
	}

}
