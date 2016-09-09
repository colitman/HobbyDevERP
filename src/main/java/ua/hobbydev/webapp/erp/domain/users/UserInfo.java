/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import ua.hobbydev.webapp.erp.domain.EntityInterface;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_info")
public class UserInfo implements IdentifiedEntityInterface {

    @Id
    @Column(name="key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long key;

    @OneToOne
    @JoinColumn(name = "user_key")
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "phone")
    private String corporatePhoneNumber;

    @Column(name = "start_work_date")
    private Date startOfWork;

    public UserInfo() {
        this.key = -1L;
        this.user = null;
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.email = "";
        this.imageUrl = "/res/app/media/defaults/user_image.png";
        this.corporatePhoneNumber = "";
        this.startOfWork = new Date();
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
