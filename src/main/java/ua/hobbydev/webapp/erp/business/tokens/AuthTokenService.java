/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.tokens;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hobbydev.webapp.erp.business.DefaultService;
import ua.hobbydev.webapp.erp.domain.users.AuthToken;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthTokenService extends DefaultService implements AuthTokenServiceInterface {

    @Override
    @Transactional
    public List<AuthToken> getByUserKey(Long userKey) {

        List<AuthToken> allTokens = getDAO().getAll(AuthToken.class);
        List<AuthToken> userTokens = new ArrayList<AuthToken>();

        for(AuthToken t:allTokens) {
            if(t.getUser().getKey().equals(userKey)) {
                userTokens.add(t);
            }
        }

        return userTokens;
    }
}
