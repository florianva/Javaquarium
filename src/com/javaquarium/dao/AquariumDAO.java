package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonUserDO;
import com.javaquarium.util.HibernateUtils;

public class AquariumDAO implements IAquariumDAO {

	@Override
	public void add(final PoissonUserDO aquarium) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();

		s.save(aquarium);

		t.commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoissonUserDO> findByUser(final int userId) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		Query q = s.createQuery("From PoissonUserDO as p where p.utilisateur like ?");
		q.setInteger(0, userId);

		final List<PoissonUserDO> aquarium = q.list();

		tx.commit();
		s.close();

		return aquarium;
	}

	@Override
	public void delete(int userId, int poissonId) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		Query q = s.createQuery("From PoissonUserDO as p where p.utilisateur = :user and p.poisson = :poisson");
		q.setInteger("user", userId);
		q.setInteger("poisson", poissonId);

		PoissonUserDO poisson = (PoissonUserDO) q.setMaxResults(1).uniqueResult();
		if (poisson != null) {
			s.delete(poisson);
		}

		tx.commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clean(int userId) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		Query q = s.createQuery("From PoissonUserDO as p where p.utilisateur = :user");
		q.setInteger("user", userId);

		List<PoissonUserDO> poissons = q.list();
		for (PoissonUserDO poisson : poissons) {
			s.delete(poisson);
		}

		tx.commit();
		s.close();
	}

}
