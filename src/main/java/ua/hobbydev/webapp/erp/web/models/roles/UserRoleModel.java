/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.roles;

import ua.hobbydev.webapp.erp.domain.roles.UserRole;
import ua.hobbydev.webapp.erp.domain.users.User;
import ua.hobbydev.webapp.erp.web.models.users.FlatUserCollectionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro.romenskyi on 9/12/2016.
 */
public class UserRoleModel {

    private Long key;
    private String name;
    private String description;
    private List<FlatUserCollectionItem> users;
    private String[] authorities;

    public UserRoleModel(UserRole role) {
        this.key = role.getKey();
        this.name = role.getName();
        this.description = role.getDescription();
        this.users = new ArrayList<FlatUserCollectionItem>();

        for(User u:role.getUsers()) {
            this.users.add(new FlatUserCollectionItem(u));
        }

        this.authorities = role.getAuthorities().split(",");

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FlatUserCollectionItem> getUsers() {
        return users;
    }

    public void setUsers(List<FlatUserCollectionItem> users) {
        this.users = users;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }
}
