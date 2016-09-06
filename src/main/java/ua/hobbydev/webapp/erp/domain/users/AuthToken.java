/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "auth_tokens")
public class AuthToken implements IdentifiedEntityInterface, Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_key")
    private User user;

    @Id
    @Column(name="token", nullable=false)
    @Type(type="text")
    private String token;

    @Column(name = "expires", nullable = false)
    private Date expires;

    public AuthToken() {
        this.user = null;
        this.token = "";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 7);
        this.expires = c.getTime();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    @Transient
    public Long getKey() {
        return user.getKey();
    }

    @Override
    @Transient
    public void setKey(Long key) {
        this.user.setKey(key);
    }
}
