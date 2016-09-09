/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;

import javax.persistence.*;

@Entity
@Table(name="creds")
public class Credentials implements IdentifiedEntityInterface {

	@Id
	@Column(name = "key")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long key;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_key", nullable = false)
	private User user;

	@Column(name="password", nullable=false)
	@Type(type="text")
	private String password;

	public Credentials() {
		this.key = -1L;
		this.user = null;
		this.password = "";
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

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
