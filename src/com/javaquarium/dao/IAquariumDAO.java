package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonUserDO;

/**
 * Classic Dao
 * 
 * @author geoffrey
 */
public interface IAquariumDAO {
	public void add(final PoissonUserDO aquarium);

	public void delete(final int userId, final int poissonId);

	public List<PoissonUserDO> findByUser(final int userId);
}
