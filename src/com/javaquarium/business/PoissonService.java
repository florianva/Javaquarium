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
		// final PoissonDAO poissonDAO = new PoissonDAO();

		for (PoissonDO poissonDO : poissonDao.list()) {
			listPoissons.add(BeanHelper.mapToVO(poissonDO));
		}

		return listPoissons;
	}

	@Override
	public Boolean isExist(final PoissonVO poisson) {

		final List<PoissonVO> listPoissons = new LinkedList<PoissonVO>();

		for (PoissonDO poissonDO : poissonDao.getByNom(poisson.getNom())) {
			listPoissons.add(BeanHelper.mapToVO(poissonDO));
		}

		return listPoissons.isEmpty();
	}

	@Override
	public void save(PoissonVO poissonForm) {
		// final PoissonDAO poissonDAO = new PoissonDAO();
		poissonDao.insert(BeanHelper.mapToDO(poissonForm));
	}

	/**
	 * @param poissonDao
	 *            the poissonDao to set
	 */
	public void setPoissonDao(IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}

}