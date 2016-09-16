/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.roles;

import ua.hobbydev.webapp.erp.business.DefaultServiceInterface;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.domain.roles.UserRole;

import java.util.List;

public interface RoleServiceInterface extends DefaultServiceInterface {

	/**
	 * Checks whether the role with provided name exists
	 *
	 * @param name name to check
	 * @return true is role with provided name exists; false otherwise
	 */
	boolean exists(String name);

	/**
	 * Checks whether the role with provided key exists
	 *
	 * @param key key to check
	 * @return true is role with provided key exists; false otherwise
	 */
	boolean exists(Long key);

	/**
	 * Gets role by key
	 *
	 * @param key key to search
	 *
	 * @return Role with provided ID
	 *
	 * @throws ResourceNotFoundException if role with provided ID does not exist
	 */
	UserRole get(Long key) throws ResourceNotFoundException;

	/**
	 * Gets role by name
	 *
	 * @param name name to search
	 *
	 * @return Role with provided name
	 *
	 * @throws ResourceNotFoundException if role with provided name does not exist
	 */
	UserRole get(String name) throws ResourceNotFoundException;

	/**
	 * Gets all roles
	 *
	 * @return a list of all roles or empty list if there are no role entries
	 */
	List<UserRole> list();
	

}