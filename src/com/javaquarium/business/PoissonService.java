package com.javaquarium.business;

import java.util.LinkedList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;

/**
 * Classic Service
 * 
 * @author Florian
 *
 */
public class PoissonService implements IPoissonService {

	private IPoissonDAO poissonDao;

	@Override
	public List<PoissonVO> getAll() {

		final List<PoissonVO> listPoissons = new LinkedList<PoissonVO>();
		// final PoissonDAO poissonDAO = new PoissonDAO();

		for (PoissonDO poissonDO : poissonDao.list()) {
			listPoissons.add(mapToVO(poissonDO));
		}

		return listPoissons;
	}

	@Override
	public Boolean isExist(final PoissonVO poisson) {

		final List<PoissonVO> listPoissons = new LinkedList<PoissonVO>();

		for (PoissonDO poissonDO : poissonDao.getByNom(poisson.getNom())) {
			listPoissons.add(mapToVO(poissonDO));
		}

		return listPoissons.isEmpty();
	}

	@Override
	public void save(PoissonVO poissonForm) {
		// final PoissonDAO poissonDAO = new PoissonDAO();
		poissonDao.insert(mapToDO(poissonForm));
	}

	@Override
	public PoissonVO mapToVO(final PoissonDO d) {
		final PoissonVO poissonVO = new PoissonVO();
		poissonVO.setNom(d.getNom());
		poissonVO.setDescription(d.getDescription());
		poissonVO.setCouleur(d.getCouleur());
		poissonVO.setPrix(d.getPrix());
		poissonVO.setDimension(d.getLongueur().toString() + "x" + d.getLargeur().toString());
		return poissonVO;
	}

	@Override
	public PoissonDO mapToDO(final PoissonVO vo) {
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
	 * @param poissonDao
	 *            the poissonDao to set
	 */
	public void setPoissonDao(IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}

}