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
public class AquariumVO extends ActionForm {

	private static final long serialVersionUID = -2663549144418124947L;

	private List<String> poissons;

	public AquariumVO() {
		this.poissons = new ArrayList<>();
	}

	/**
	 * @return the poissons
	 */
	public List<String> getPoissons() {
		return poissons;
	}

	/**
	 * @param poissons
	 *            the poissons to set
	 */
	public void setPoissons(List<String> poissons) {
		this.poissons = poissons;
	}

}
