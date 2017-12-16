package com.javaquarium.business;

import com.javaquarium.beans.web.AquariumVO;

/**
 * Classic Service
 * 
 * @author Geoffrey
 *
 */
public class AquariumService implements IAquariumService {

	@Override
	public AquariumVO getAquarium(int userId) {

		return new AquariumVO();
	}

	@Override
	public void addPoisson(int userId) {
		// TODO Auto-generated method stub

	}

}