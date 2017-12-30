package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.BeanHelper;
import com.javaquarium.beans.data.PoissonUserDO;
import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.dao.IAquariumDAO;

/**
 * Classic Service
 * 
 * @author Geoffrey
 *
 */
public class AquariumService implements IAquariumService {

	private IAquariumDAO aquaDao;

	/**
	 * @param aquaDao
	 *            the aquaDao to set
	 */
	public void setAquaDao(IAquariumDAO aquaDao) {
		this.aquaDao = aquaDao;
	}

	@Override
	public PoissonUserVO getAquarium(final int userId) {
		return BeanHelper.map(aquaDao.findByUser(userId));
	}

	@Override
	public void addPoisson(final PoissonUserVO aquariumvo, final int userId) {

		final List<PoissonUserDO> aquarium = BeanHelper.map(aquariumvo);

		PoissonUserDO poissonUserDO = aquarium.get(aquarium.size() - 1);
		poissonUserDO.setUtilisateur(userId);

		aquaDao.add(poissonUserDO);

	}

	@Override
	public void removePoisson(int poissonId, int userId) {
		aquaDao.delete(userId, poissonId);
	}

	@Override
	public void clean(int userId) {
		aquaDao.clean(userId);
	}

}