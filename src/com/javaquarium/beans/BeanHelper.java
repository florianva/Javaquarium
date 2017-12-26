package com.javaquarium.beans;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.PoissonUserDO;
import com.javaquarium.beans.web.PoissonUserVO;
import com.javaquarium.beans.web.PoissonVO;

/**
 * 
 * Helper use to convert Bean
 * 
 * @author geoffrey
 *
 */
public class BeanHelper {

	/**
	 * convert PoissonDO to PoissonVO
	 */
	public static PoissonVO map(final PoissonDO d) {
		final PoissonVO poissonVO = new PoissonVO();
		poissonVO.setCode(d.getCode());
		poissonVO.setNom(d.getNom());
		poissonVO.setDescription(d.getDescription());
		poissonVO.setCouleur(d.getCouleur());
		poissonVO.setPrix(d.getPrix());
		poissonVO.setDimension(d.getLongueur().toString() + "x" + d.getLargeur().toString());
		return poissonVO;
	}

	/**
	 * convert PoissonVO to PoissonDO
	 */
	public static PoissonDO map(final PoissonVO vo) {
		final PoissonDO poissonDO = new PoissonDO();
		if (vo.getCode() != null) {
			poissonDO.setCode(vo.getCode());
		}
		poissonDO.setNom(vo.getNom());
		poissonDO.setDescription(vo.getDescription());
		poissonDO.setCouleur(vo.getCouleur());
		poissonDO.setPrix(vo.getPrix());
		String[] parts = vo.getDimension().split("x");
		poissonDO.setLongueur(Float.parseFloat(parts[0]));
		poissonDO.setLargeur(Float.parseFloat(parts[1]));
		return poissonDO;
	}

	/**
	 * 
	 * convert list of poissonUserDo to PoissonUserVo
	 */
	public static PoissonUserVO map(List<PoissonUserDO> dos) {
		PoissonUserVO vo = new PoissonUserVO();

		for (PoissonUserDO aquaDo : dos) {
			vo.getPoissons().add(BeanHelper.map(aquaDo.getPoisson()));
		}
		return vo;
	}

	public static List<PoissonUserDO> map(PoissonUserVO vo) {
		List<PoissonUserDO> dos = new ArrayList<>();
		for (PoissonVO poisson : vo.getPoissons()) {
			PoissonUserDO poissonUserDO = new PoissonUserDO();
			poissonUserDO.setPoisson(map(poisson));
			dos.add(poissonUserDO);
		}
		return dos;
	}
}
