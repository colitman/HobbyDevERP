/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.users;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.data.NameColumn;
import ua.hobbydev.webapp.erp.domain.UniqueNamedEntityInterface;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User implements UniqueNamedEntityInterface {
	
	@Id
	@Column(name="key")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long key;
	
	@Column(name="username", nullable=false, unique=true)
	@NameColumn
	@Type(type="text")
	private String username;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private PersonalInfo personalInfo;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private UserInfo userInfo;

	@ManyToOne
	@JoinColumn(name = "line_manager_key"/*, nullable = false*/)
	private User lineManager;

	@OneToMany(mappedBy = "lineManager", cascade = CascadeType.PERSIST)
	private List<User> subordinates;

	public User() {
		this.key = -1L;
		this.username = "";
		this.userInfo = new UserInfo();
		this.userInfo.setUser(this);

		this.personalInfo = new PersonalInfo();
		this.personalInfo.setUser(this);

		this.lineManager = null;
		this.subordinates = new ArrayList<User>();
	}

	@Override
	public Long getKey() {
		return key;
	}

	@Override
	public void setKey(Long key) {
		this.key = key;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	@Override
	@Transient
	public String getName() {
		return getUsername();
	}

	@Override
	@Transient
	public void setName(String name) {
		setUsername(name);
	}

	public User getLineManager() {
		return lineManager;
	}

	public void setLineManager(User lineManager) {
		this.lineManager = lineManager;
	}

	public List<User> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<User> subordinates) {
		this.subordinates = subordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
