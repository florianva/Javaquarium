package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
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

	void save(PoissonVO poissonForm);

	PoissonVO mapToVO(final PoissonDO d);

	PoissonDO mapToDO(final PoissonVO v);
}
