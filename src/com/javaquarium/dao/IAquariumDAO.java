package com.javaquarium.dao;

import com.javaquarium.beans.data.AquariumDO;

/**
 * Classic Dao
 * 
 * @author geoffrey
 */
public interface IAquariumDAO {
	public void create(AquariumDO aquarium);

	public void update(AquariumDO aquarium);

	public AquariumDO findOneByUser(int userId);
}
