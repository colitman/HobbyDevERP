/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain.roles;

import org.hibernate.annotations.Type;
import ua.hobbydev.webapp.erp.data.NameColumn;
import ua.hobbydev.webapp.erp.domain.UniqueNamedEntityInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
public class UserRole implements UniqueNamedEntityInterface {

	@Id
	@Column(name="key")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long key;

	@Column(name="name", nullable=false, unique=true)
	@NameColumn
	@Type(type="text")
	private String name;

	@Column(name="description")
	@Type(type="text")
	private String description;

	@OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST)
	private List<User> users;

	@Column(name = "authorities")
	@Type(type = "text")
	private String authorities;

	public UserRole() {
		this.key = -1L;
		this.name = "";
		this.description = "";
		this.users = new ArrayList<User>();
		this.authorities = "";
	}

	@Override
	public Long getKey() {
		return key;
	}

	@Override
	public void setKey(Long key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
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
		UserRole other = (UserRole) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
