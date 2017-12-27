package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.BeanHelper;
import com.javaquarium.beans.data.PoissonUserDO;
import com.javaquarium.beans.web.PoissonUserVO;
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
		return BeanHelper.map(dao.findByUser(userId));
	}

	@Override
	public void addPoisson(final PoissonUserVO aquariumvo, final int userId) {

		final List<PoissonUserDO> aquarium = BeanHelper.map(aquariumvo);

		PoissonUserDO poissonUserDO = aquarium.get(aquarium.size() - 1);
		poissonUserDO.setUtilisateur(userId);

		dao.add(poissonUserDO);

	}

	@Override
	public void removePoisson(int poissonId, int userId) {
		dao.delete(userId, poissonId);
	}

	@Override
	public void clean(int userId) {
		dao.clean(userId);
	}

}