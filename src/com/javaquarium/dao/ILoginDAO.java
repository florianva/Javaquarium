package com.javaquarium.dao;

import com.javaquarium.beans.data.LoginDO;

public interface ILoginDAO {
	public int getUserId(final LoginDO login);
}