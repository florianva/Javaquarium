package com.javaquarium.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classic Bean
 * 
 * @author Geoffrey
 *
 */
@Entity
@Table(name = "Aquarium")
public class AquariumDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer identifiant;

	@Column(name = "userId")
	private Integer utilisateur;

	/**
	 * @return the identifiant
	 */
	public Integer getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant
	 *            the identifiant to set
	 */
	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the utilisateur
	 */
	public Integer getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(Integer utilisateur) {
		this.utilisateur = utilisateur;
	}

}
