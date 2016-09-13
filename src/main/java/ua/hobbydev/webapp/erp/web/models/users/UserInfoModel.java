/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.users;

import ua.hobbydev.webapp.erp.domain.users.UserInfo;

import java.util.Date;

public class UserInfoModel {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String imageUrl;
    private String corporatePhoneNumber;
    private Date startOfWork;

    public UserInfoModel(UserInfo userInfo) {
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.middleName = userInfo.getMiddleName();
        this.email = userInfo.getEmail();
        this.imageUrl = userInfo.getImageUrl();
        this.corporatePhoneNumber = userInfo.getCorporatePhoneNumber();
        this.startOfWork = userInfo.getStartOfWork();
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCorporatePhoneNumber() {
        return corporatePhoneNumber;
    }

    public void setCorporatePhoneNumber(String corporatePhoneNumber) {
        this.corporatePhoneNumber = corporatePhoneNumber;
    }

    public Date getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(Date startOfWork) {
        this.startOfWork = startOfWork;
    }
}
