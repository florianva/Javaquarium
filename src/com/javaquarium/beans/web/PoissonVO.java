package com.javaquarium.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Classic Bean
 * 
 * @author Florian
 *
 */
public class PoissonVO extends ActionForm {

	private static final long serialVersionUID = -3671164395721040986L;
	private String nom;
	private String description;
	private String couleur;
	private String dimension;
	private Integer prix;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur
	 *            the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		errors.clear();
		if (getNom().isEmpty()) {
			errors.add("error", new ActionMessage("error.newespece.nom"));
		}
		if (getPrix() == null) {
			errors.add("error", new ActionMessage("error.newespece.prix"));
		}
		if (getDimension().isEmpty()) {
			errors.add("error", new ActionMessage("error.newespece.dim"));
		} else if (getDimension().split("x").length != 2) {
			errors.add("error", new ActionMessage("error.newespece.dim.invalidformat"));
		}

		return errors;

	}

}
