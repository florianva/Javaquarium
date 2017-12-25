package com.javaquarium.business;

import com.javaquarium.beans.BeanHelper;
import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.AquariumDAO;
import com.javaquarium.dao.IAquariumDAO;

/**
 * Classic Service
 * 
 * @author Geoffrey
 *
 */
public class AquariumService implements IAquariumService {

	private IAquariumDAO dao;

	public AquariumService() {
		dao = new AquariumDAO();
	}

	@Override
	public PoissonUserVO getAquarium(final int userId) {

		return BeanHelper.mapToVo(dao.findByUser(userId));
	}

	@Override
	public void addPoisson(final PoissonUserVO aquariumvo, final PoissonVO poisson) {

		// dao.add(aquarium);

	}

}