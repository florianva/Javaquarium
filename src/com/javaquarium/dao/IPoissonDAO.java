package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

public interface IPoissonDAO {
	public void insert(PoissonDO poisson);
	public List<PoissonDO> list();
}
