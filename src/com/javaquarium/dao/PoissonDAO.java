package com.javaquarium.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.util.HibernateUtils;

@SuppressWarnings("unchecked")
public class PoissonDAO implements IPoissonDAO {

	public void insert(PoissonDO poisson) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();

		s.save(poisson);

		t.commit();
		s.close();
	}

	public List<PoissonDO> list() {
		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		final Query q = s.createQuery("from PoissonDO");
		final ArrayList<PoissonDO> list = (ArrayList<PoissonDO>) q.list();

		tx.commit();
		s.close();

		return list;

	}
}
