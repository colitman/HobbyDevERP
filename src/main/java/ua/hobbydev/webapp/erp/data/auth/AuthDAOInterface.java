/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data.auth;

import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;

public interface AuthDAOInterface {

    boolean usernameExists(String username);
    String getPasswordForUsername(String username) throws ObjectNotExistsException;
}
