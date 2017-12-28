package com.javaquarium.business;

import java.util.LinkedList;
import java.util.List;

import com.javaquarium.beans.BeanHelper;
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

		for (PoissonDO poissonDO : poissonDao.list()) {
			listPoissons.add(BeanHelper.map(poissonDO));
		}

		return listPoissons;
	}

	@Override
	public Boolean isExist(final PoissonVO poisson) {

		final List<PoissonVO> listPoissons = new LinkedList<PoissonVO>();

		for (PoissonDO poissonDO : poissonDao.getByNom(poisson.getNom())) {
			listPoissons.add(BeanHelper.map(poissonDO));
		}

		return listPoissons.isEmpty();
	}

	public PoissonDO mapToDO(final PoissonVO v) {
		final PoissonDO poissonDO = new PoissonDO();
		poissonDO.setNom(v.getNom());
		poissonDO.setDescription(v.getDescription());
		poissonDO.setCouleur(v.getCouleur());
		poissonDO.setPrix(v.getPrix());
		String[] parts = v.getDimension().split("x");
		poissonDO.setLongueur(Float.parseFloat(parts[0]));
		poissonDO.setLargeur(Float.parseFloat(parts[1]));
		return poissonDO;
	@Override
	public void save(PoissonVO poissonForm) {
		poissonDao.insert(BeanHelper.map(poissonForm));
	}

	/**
	 * @param poissonDao
	 *            the poissonDao to set
	 */
	public void setPoissonDao(IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}

}