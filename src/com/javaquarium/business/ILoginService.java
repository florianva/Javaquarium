package com.javaquarium.business;

import com.javaquarium.beans.data.LoginDO;
import com.javaquarium.beans.web.LoginVO;

/**
 * Classic Service Interface
 * 
 * @author Florian
 *
 */
public interface ILoginService {

	Boolean isExist(LoginVO d);

	LoginVO mapToVO(final LoginDO d);

	LoginDO mapToDO(final LoginVO d);
}
