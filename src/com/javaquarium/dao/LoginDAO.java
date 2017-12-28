package com.javaquarium.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.LoginDO;
import com.javaquarium.util.HibernateUtils;

public class LoginDAO implements ILoginDAO {

	public Boolean isExist(LoginDO login) {

		final Session s = HibernateUtils.getSession();
		final Transaction tx = s.beginTransaction();

		final Query q = s.createQuery("from LoginDO where user= :username and password= :password");
		q.setString("username", login.getUser());
		q.setString("password", login.getPassword());
		final Object result = q.uniqueResult();

		tx.commit();
		s.close();

		return (result != null);
	}

}
