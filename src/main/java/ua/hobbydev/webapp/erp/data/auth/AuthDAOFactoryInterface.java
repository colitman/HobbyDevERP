/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data.auth;

public interface AuthDAOFactoryInterface {
    AuthDAOInterface getDao(String authDaoName);
}
