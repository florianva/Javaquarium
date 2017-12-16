package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

/**
 * Classic Dao
 * 
 * @author florian
 */
public interface IPoissonDAO {
	public void insert(PoissonDO poisson);

	public List<PoissonDO> list();

	public List<PoissonDO> getByNom(final String nom);
}
