/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.users;

import ua.hobbydev.webapp.erp.domain.users.User;

/**
 * Created by dmytro.romenskyi on 9/14/2016.
 */
public class FlatUserCollectionItem {

    private Long key;
    private String username;
    private String firstName;
    private String lastName;

    public FlatUserCollectionItem(User user) {
        this.key = user.getKey();
        this.username = user.getUsername();
        this.firstName = user.getUserInfo().getFirstName();
        this.lastName = user.getUserInfo().getLastName();
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
