package com.javaquarium.business;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.beans.web.AquariumVO;
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
	public AquariumVO getAquarium(final int userId) {
		// TODO : create aquarium if not exist yet

		AquariumVO aqua = convert(dao.findOneByUser(userId));

		return aqua == null ? new AquariumVO() : aqua;
	}

	@Override
	public void addPoisson(final int userId, final String poissonname) {
		// TODO Auto-generated method stub

	}

	public AquariumVO convert(AquariumDO aquaDo) {
		AquariumVO vo = new AquariumVO();

		return vo;
	}

}