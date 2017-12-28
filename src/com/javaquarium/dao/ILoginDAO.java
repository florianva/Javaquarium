package com.javaquarium.dao;

import com.javaquarium.beans.data.LoginDO;

public interface ILoginDAO {
	public Boolean isExist(final LoginDO login);
}