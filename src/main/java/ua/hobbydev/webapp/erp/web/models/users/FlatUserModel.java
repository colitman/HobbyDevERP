/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.users;

import ua.hobbydev.webapp.erp.domain.users.User;

/**
 * Created by dmytro.romenskyi on 9/12/2016.
 */
public class FlatUserModel {

    private Long key;
    private String username;
    private PersonalInfoModel personalInfo;
    private UserInfoModel userInfo;

    public FlatUserModel(User sub) {
        this.key = sub.getKey();
        this.username = sub.getUsername();
        this.personalInfo = new PersonalInfoModel(sub.getPersonalInfo());
        this.userInfo = new UserInfoModel(sub.getUserInfo());
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

    public PersonalInfoModel getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfoModel personalInfo) {
        this.personalInfo = personalInfo;
    }

    public UserInfoModel getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoModel userInfo) {
        this.userInfo = userInfo;
    }
}
