/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.users;

import ua.hobbydev.webapp.erp.domain.users.PersonalInfo;

import java.util.Date;

public class PersonalInfoModel  {

    private Date birthday;
    private String phoneNumber;
    private String skypeName;

    public PersonalInfoModel(PersonalInfo personalInfo) {
        this.birthday = personalInfo.getBirthday();
        this.phoneNumber = personalInfo.getPhoneNumber();
        this.skypeName = personalInfo.getSkypeName();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
    }
}
