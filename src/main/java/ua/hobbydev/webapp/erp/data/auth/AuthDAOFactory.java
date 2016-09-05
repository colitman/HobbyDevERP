/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data.auth;

import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Map;

@Component
public class AuthDAOFactory implements AuthDAOFactoryInterface {

    private Map<String, AuthDAOInterface> daos;

    public AuthDAOFactory() {
        daos = new Hashtable<String, AuthDAOInterface>();
    }

    @Override
    public AuthDAOInterface getDao(String authDaoName) {

        if(daos.containsKey(authDaoName)) {
            return daos.get(authDaoName);
        }

        AuthDAOInterface dao = null;
        Class daoClass = null;

        try {
            daoClass = Class.forName(authDaoName);
            dao = (AuthDAOInterface) daoClass.newInstance();
            daos.put(daoClass.getName(), dao);
        } catch (ClassNotFoundException e) {
            //TODO add logging
        } catch (InstantiationException e) {
            //TODO add logging
        } catch (IllegalAccessException e) {
            //TODO add logging
        }

        return dao;
    }
}
