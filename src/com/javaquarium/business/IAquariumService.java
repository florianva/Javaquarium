package com.javaquarium.business;

import com.javaquarium.beans.web.PoissonUserVO;

/**
 * Classic Service Interface
 * 
 * @author Geoffrey
 *
 */
public interface IAquariumService {
	/**
	 * 
	 * @param userId
	 * @return the aquarium of the user
	 */
	PoissonUserVO getAquarium(final int userId);

	/**
	 * 
	 * @param aquariumvo
	 * @param poisson
	 * @return void
	 */
	void addPoisson(final PoissonUserVO aquariumvo, final int userId);

}
