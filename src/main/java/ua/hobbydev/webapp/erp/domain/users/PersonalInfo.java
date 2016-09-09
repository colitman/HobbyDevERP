/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_personal_info")
public class PersonalInfo implements IdentifiedEntityInterface {

    @Id
    @Column(name="key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long key;

    @OneToOne
    @JoinColumn(name = "user_key", nullable = false)
    private User user;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    @Type(type="text")
    private String phoneNumber;

    @Column(name = "skype")
    @Type(type="text")
    private String skypeName;

    public PersonalInfo() {
        this.key = -1L;
        this.user = null;
        this.birthday = null;
        this.phoneNumber = "";
        this.skypeName = "";
    }

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public void setKey(Long key) {
        this.key = key;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
