/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.users;

import ua.hobbydev.webapp.erp.domain.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro.romenskyi on 9/12/2016.
 */
public class UserModel {

    private Long key;
    private String username;
    private PersonalInfoModel personalInfo;
    private UserInfoModel userInfo;
    private FlatUserModel lineManager;
    private List<FlatUserModel> subordinates;

    public UserModel(User user) {
        this.key = user.getKey();
        this.username = user.getUsername();
        this.personalInfo = new PersonalInfoModel(user.getPersonalInfo());
        this.userInfo = new UserInfoModel(user.getUserInfo());
        this.lineManager = user.getLineManager() == null? null : new FlatUserModel(user.getLineManager());
        this.subordinates = new ArrayList<FlatUserModel>();

        for(User sub : user.getSubordinates()) {
            this.subordinates.add(new FlatUserModel(sub));
        }
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

    public FlatUserModel getLineManager() {
        return lineManager;
    }

    public void setLineManager(FlatUserModel lineManager) {
        this.lineManager = lineManager;
    }

    public List<FlatUserModel> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<FlatUserModel> subordinates) {
        this.subordinates = subordinates;
    }
}
