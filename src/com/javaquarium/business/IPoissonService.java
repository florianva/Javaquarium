package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.web.PoissonVO;

/**
 * Classic Service Interface
 * 
 * @author Florian
 *
 */
public interface IPoissonService {
	/**
	 * Methode de récupération de la liste des poissons
	 * 
	 * @return List<PoissonVO>
	 * @author Florian
	 */
	List<PoissonVO> getAll();

	Boolean isExist(PoissonVO poissonForm);

	void save(PoissonVO poissonForm);
}
