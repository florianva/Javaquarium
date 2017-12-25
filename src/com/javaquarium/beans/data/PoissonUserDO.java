package com.javaquarium.beans.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classic Bean
 * 
 * @author Geoffrey
 *
 */
@Entity
@Table(name = "Aquarium")
public class PoissonUserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer identifiant;

	@Column(name = "userId")
	private Integer utilisateur;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "poisson")
	private PoissonDO poisson;

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
	 * @return the poisson
	 */
	public PoissonDO getPoisson() {
		return poisson;
	}

	/**
	 * @param poisson
	 *            the poisson to set
	 */
	public void setPoisson(PoissonDO poisson) {
		this.poisson = poisson;
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
