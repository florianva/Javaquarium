package com.javaquarium.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.LoginDO;
import com.javaquarium.util.HibernateUtils;

public class LoginDAO implements ILoginDAO {

	/**
	 * return the userId if the user exist or -1 if the user doesn't exist
	 */
	@Override
	public int getUserId(LoginDO login) {

		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		final Query q = s.createQuery("from LoginDO where user= :username and password= :password");
		q.setString("username", login.getUser());
		q.setString("password", login.getPassword());
		final LoginDO result = (LoginDO) q.uniqueResult();

		tx.commit();
		s.close();

		return result != null ? result.getCode() : -1;
	}

	@Override
	public void insert(LoginDO login) {
		final Session s = HibernateUtils.getSession();
		final Transaction t = s.beginTransaction();

		s.save(login);

		t.commit();
		s.close();
	}

}
