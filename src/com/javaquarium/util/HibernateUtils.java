package com.javaquarium.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Unique point d'acces a la base de données via {@link Session}. Recommande par
 * l'équipe Hibernate
 * 
 * @author Max
 * 
 */
@SuppressWarnings("deprecation")
public class HibernateUtils {

	// Singleton
	private static final SessionFactory sessionFactory;

	private HibernateUtils() {
		throw new IllegalStateException("Utility class");
	}

	// Cree une unique instance de la SessionFactory a partir de
	// hibernate.cfg.xml
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException ex) {
			throw new RuntimeException("Probleme de configuration : " + ex.getMessage(), ex);
		}
	}

	// Retourne la session Hibernate (singleton)
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}