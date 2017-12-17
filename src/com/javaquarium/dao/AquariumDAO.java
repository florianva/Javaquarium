package com.javaquarium.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.util.HibernateUtils;

public class AquariumDAO implements IAquariumDAO {

	@Override
	public void create(AquariumDO aquarium) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();

		s.save(aquarium);

		t.commit();
		s.close();
	}

	@Override
	public void update(AquariumDO aquarium) {
		// TODO Auto-generated method stub

	}

	@Override
	public AquariumDO findOneByUser(int userId) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		Query q = s.createQuery("From AquariumDO as p where p.utilisateur like ?");
		q.setInteger(0, userId);

		final AquariumDO aquarium = (AquariumDO) q.uniqueResult();

		tx.commit();
		s.close();

		return aquarium;
	}

}
