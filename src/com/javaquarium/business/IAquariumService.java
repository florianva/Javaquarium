package com.javaquarium.business;

import com.javaquarium.beans.web.AquariumVO;

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
	AquariumVO getAquarium(final int userId); // todo : update when user system will be operational

	void addPoisson(final int userId, final String poissonname);

}
