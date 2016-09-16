/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.config;

/**
 * Created by dmytro.romenskyi on 9/16/2016.
 */
public class AccessMatrix {

    public enum Authority {
        VIEW_USER_PAGE,
        VIEW_USER_EDIT_PAGE,

        VIEW_ADMIN_MENU,
        VIEW_ROLES_ADMIN_PAGE,
        VIEW_USERS_ADMIN_PAGE,

        ADD_USER_ROLE,

        GET_USERS_LIST,
        GET_USER_INFO,
        UPDATE_USER_INFO
    }
}
