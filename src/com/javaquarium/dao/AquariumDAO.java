package com.javaquarium.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.util.HibernateUtils;

public class AquariumDAO implements IAquariumDAO {

	@Override
	public void create(AquariumDO aquarium) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AquariumDO aquarium) {
		// TODO Auto-generated method stub

	}

	@Override
	public AquariumDO findOneByUser(int userId) {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		Query q = s.createQuery("From AquariumDO as p where p.id like ?");
		q.setInteger(0, userId);

		final AquariumDO aquarium = (AquariumDO) q.uniqueResult();

		tx.commit();
		s.close();

		return aquarium;
	}

}
