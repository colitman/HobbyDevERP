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
        // ~ === Menu items view authorities
        VIEW_ADMIN_MENU,

        // ~ === Pages view authorities
            // ~ === Admin area pages
            VIEW_ROLES_PAGE,
            VIEW_USERS_PAGE,

            // ~ === User related pages
            VIEW_USER_PAGE,

        // ~ === Actions authorities
            // ~ === User related actions
            EDIT_USER,
            DELETE_USER,
            ADD_USER,

            // ~ === Role related actions
            EDIT_ROLE,
            ADD_ROLE,
            DELETE_ROLE
    }
}
