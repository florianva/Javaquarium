package com.javaquarium.business;

import com.javaquarium.beans.web.LoginVO;

/**
 * Classic Service Interface
 * 
 * @author Florian
 *
 */
public interface ILoginService {

	Boolean isExist(LoginVO d);
}
