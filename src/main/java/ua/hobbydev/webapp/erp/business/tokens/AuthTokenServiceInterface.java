/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.tokens;

import ua.hobbydev.webapp.erp.business.DefaultServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.AuthToken;

import java.util.List;

/**
 * Created by dmytro.romenskyi on 9/8/2016.
 */
public interface AuthTokenServiceInterface extends DefaultServiceInterface {

    List<AuthToken> getByUserKey(Long userKey);
}
