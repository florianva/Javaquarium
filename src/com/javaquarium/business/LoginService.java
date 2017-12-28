package com.javaquarium.business;

import com.javaquarium.beans.data.LoginDO;
import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.dao.ILoginDAO;

public class LoginService implements ILoginService {

	private ILoginDAO loginDao;

	public Boolean isExist(LoginVO vo) {
		return loginDao.isExist(mapToDO(vo));
	}

	public LoginVO mapToVO(LoginDO d) {
		final LoginVO loginVO = new LoginVO();
		loginVO.setUser(d.getUser());
		loginVO.setPassword(d.getPassword());
		return loginVO;
	}

	public LoginDO mapToDO(LoginVO v) {
		final LoginDO loginDO = new LoginDO();
		loginDO.setUser(v.getUser());
		loginDO.setPassword(v.getPassword());
		return loginDO;
	}

	/**
	 * @param loginDao
	 *            the loginDao to set
	 */
	public void setLoginDao(ILoginDAO loginDao) {
		this.loginDao = loginDao;
	}

}
