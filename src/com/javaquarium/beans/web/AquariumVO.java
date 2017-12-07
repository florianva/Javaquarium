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

	private String nomAquarium;
	private List<String> poissons;

	public AquariumVO() {
		this.nomAquarium = new String();
		this.poissons = new ArrayList<>();
	}

	/**
	 * @return the nomAquarium
	 */
	public String getNomAquarium() {
		return nomAquarium;
	}

	/**
	 * @param nomAquarium
	 *            the nomAquarium to set
	 */
	public void setNomAquarium(String nomAquarium) {
		this.nomAquarium = nomAquarium;
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
