package com.javaquarium.beans;

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
	public static PoissonVO mapToVO(final PoissonDO d) {
		final PoissonVO poissonVO = new PoissonVO();
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
	public static PoissonDO mapToDO(final PoissonVO vo) {
		final PoissonDO poissonDO = new PoissonDO();
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
	public static PoissonUserVO mapToVo(List<PoissonUserDO> dos) {
		PoissonUserVO vo = new PoissonUserVO();

		for (PoissonUserDO aquaDo : dos) {
			vo.getPoissons().add(BeanHelper.mapToVO(aquaDo.getPoisson()));
		}
		return vo;
	}
}
