package com.javaquarium.business;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.beans.data.PoissonDO;
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
		AquariumDO aquado = dao.findOneByUser(userId);

		if (aquado == null) {
			aquado = new AquariumDO();
			aquado.setUtilisateur(userId);

			dao.create(aquado);
		}
		return convert(aquado);
	}

	@Override
	public void addPoisson(final int userId, final String poissonname) {
		// TODO Auto-generated method stub

	}

	public AquariumVO convert(AquariumDO aquaDo) {
		AquariumVO vo = new AquariumVO();

		try {
			for (PoissonDO p : aquaDo.getPoissons()) {
				vo.getPoissons().add(p.getNom());
			}
		} catch (Exception e) {

		}

		return vo;
	}

}