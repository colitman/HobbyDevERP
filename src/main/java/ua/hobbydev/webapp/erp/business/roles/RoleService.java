/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.roles;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hobbydev.webapp.erp.business.DefaultService;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.domain.roles.UserRole;

import java.util.List;

/**
 * Role Service
 */
@Service
public class RoleService extends DefaultService implements RoleServiceInterface {

    @Override
    @Transactional
    public boolean exists(String name) {
        try {
            return exists(UserRole.class, getDAO().getKeyByName(UserRole.class, name));
        } catch (ObjectNotExistsException e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean exists(Long key) {
        return exists(UserRole.class, key);
    }

    @Override
    @Transactional
    public UserRole get(Long key) throws ResourceNotFoundException {
        return get(UserRole.class, key);
    }

    @Override
    @Transactional
    public UserRole get(String name) throws ResourceNotFoundException {
        try {
            return get(getDAO().getKeyByName(UserRole.class, name));
        } catch (ObjectNotExistsException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<UserRole> list() {
        return list(UserRole.class);
    }
}
