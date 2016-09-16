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
@Table(name = "users_info")
public class UserInfo implements IdentifiedEntityInterface {

    @Id
    @Column(name="key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long key;

    @OneToOne
    @JoinColumn(name = "user_key", nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false)
    @Type(type="text")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Type(type="text")
    private String lastName;

    @Column(name = "middle_name")
    @Type(type="text")
    private String middleName;

    @Column(name = "email", nullable = false)
    @Type(type="text")
    private String email;

    @Column(name = "image_url", nullable = false)
    @Type(type="text")
    private String imageUrl;

    @Column(name = "phone")
    @Type(type="text")
    private String corporatePhoneNumber;

    @Column(name = "start_work_date", nullable = false)
    private Date startOfWork;

    public UserInfo() {
        this.key = -1L;
        this.user = null;
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.email = "";
        this.imageUrl = "/res/app/media/defaults/user-image.png";
        this.corporatePhoneNumber = "";
        this.startOfWork = new Date();
    }

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public void setKey(Long key) {
        this.key = key == null? -1L:key;
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
        this.firstName = firstName == null? "":firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null?"":lastName;
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
        this.email = email == null?"":email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null || imageUrl.trim().isEmpty()? "/res/app/media/defaults/user-image.png":imageUrl;
    }

    public String getCorporatePhoneNumber() {
        return corporatePhoneNumber;
    }

    public void setCorporatePhoneNumber(String corporatePhoneNumber) {
        this.corporatePhoneNumber = corporatePhoneNumber == null?"":corporatePhoneNumber;
    }

    public Date getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(Date startOfWork) {
        this.startOfWork = startOfWork == null?new Date():startOfWork;
    }
}
