/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="creds")
public class Credentials implements IdentifiedEntityInterface, Serializable {

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_key")
	private User user;

	@Column(name="password", nullable=false)
	@Type(type="text")
	private String password;

	public Credentials() {
		this.user = null;
		this.password = "";
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
