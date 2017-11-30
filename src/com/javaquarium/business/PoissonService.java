package com.javaquarium.business;

import java.util.LinkedList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;
import com.javaquarium.dao.PoissonDAO;

/**
 * Classic Service
 * 
 * @author Florian
 *
 */
public class PoissonService implements IPoissonService {

	
	private IPoissonDAO poissonDao;
	
	
	public List<PoissonVO> getAll() {

		final List<PoissonVO> listPoissons = new LinkedList<PoissonVO>();
		//final PoissonDAO poissonDAO = new PoissonDAO();

		for (PoissonDO poissonDO : poissonDao.list()) {
			listPoissons.add(mapToVO(poissonDO));
		}

		return listPoissons;
	}

	@Override
	public void save(PoissonVO poissonForm) {
		//final PoissonDAO poissonDAO = new PoissonDAO();
		poissonDao.insert(mapToDO(poissonForm));
	}

	public PoissonVO mapToVO(final PoissonDO d) {
		final PoissonVO poissonVO = new PoissonVO();
		poissonVO.setNom(d.getEspece());
		poissonVO.setDescription(d.getDescription());
		poissonVO.setCouleur(d.getCouleur());
		poissonVO.setPrix(d.getPrix());
		poissonVO.setDimension(d.getTaille());
		return poissonVO;
	}

	public PoissonDO mapToDO(final PoissonVO vo) {
		final PoissonDO poissonDO = new PoissonDO();
		poissonDO.setNom(vo.getNom());
		poissonDO.setDescription(vo.getDescription());
		poissonDO.setCouleur(vo.getCouleur());
		poissonDO.setPrix(vo.getPrix());
		poissonDO.setTaille(vo.getDimension());
		return poissonDO;
	}

	/**
	 * @param poissonDao the poissonDao to set
	 */
	public void setPoissonDao(IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}

	
	
	

}