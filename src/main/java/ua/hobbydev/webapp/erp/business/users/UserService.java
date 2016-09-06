/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hobbydev.webapp.erp.business.DefaultService;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.domain.users.User;

import java.util.List;

/**
 * User Service
 */
@Service
public class UserService extends DefaultService implements UserServiceInterface {

    @Override
    @Transactional
    public boolean exists(String username) {
        try {
            return exists(User.class, getDAO().getKeyByName(User.class, username));
        } catch (ObjectNotExistsException e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean exists(Long key) {
        return exists(User.class, key);
    }

    @Override
    @Transactional
    public User get(Long key) throws ResourceNotFoundException {
        return get(User.class, key);
    }

    @Override
    @Transactional
    public User get(String username) throws ResourceNotFoundException {
        try {
            return get(getDAO().getKeyByName(User.class, username));
        } catch (ObjectNotExistsException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<User> list() {
        return list(User.class);
    }
}
