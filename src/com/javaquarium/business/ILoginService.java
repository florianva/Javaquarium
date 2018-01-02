package com.javaquarium.business;

import com.javaquarium.beans.web.LoginVO;

/**
 * Classic Service Interface
 * 
 * @author Florian
 *
 */
public interface ILoginService {

	public int getUserId(LoginVO d);

	public Boolean isExist(LoginVO vo);

	void save(LoginVO loginForm);
}
