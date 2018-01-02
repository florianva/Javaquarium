package com.javaquarium.business;

import com.javaquarium.beans.BeanHelper;
import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.dao.ILoginDAO;

public class LoginService implements ILoginService {

	private ILoginDAO loginDao;

	@Override
	public int getUserId(LoginVO vo) {
		return loginDao.getUserId(BeanHelper.map(vo));
	}

	@Override
	public Boolean isExist(LoginVO vo) {
		return loginDao.isExist(BeanHelper.map(vo));
	}

	@Override
	public void save(LoginVO loginForm) {
		loginDao.insert(BeanHelper.map(loginForm));
	}

	/**
	 * @param loginDao
	 *            the loginDao to set
	 */
	public void setLoginDao(ILoginDAO loginDao) {
		this.loginDao = loginDao;
	}

}
