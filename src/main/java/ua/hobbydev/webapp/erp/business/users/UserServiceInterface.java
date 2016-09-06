/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.users;

import ua.hobbydev.webapp.erp.business.DefaultServiceInterface;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.domain.users.User;

import java.util.List;

public interface UserServiceInterface extends DefaultServiceInterface {

	/**
	 * Checks whether the user with provided username exists
	 *
	 * @param username username to check
	 * @return true is user with provided username exists; false otherwise
	 */
	boolean exists(String username);

	/**
	 * Checks whether the user with provided key exists
	 *
	 * @param key key to check
	 * @return true is user with provided key exists; false otherwise
	 */
	boolean exists(Long key);

	/**
	 * Gets user by key
	 *
	 * @param key key to search
	 *
	 * @return User with provided ID
	 *
	 * @throws ResourceNotFoundException if user with provided ID does not exist
	 */
	User get(Long key) throws ResourceNotFoundException;

	/**
	 * Gets user by username
	 *
	 * @param username username to search
	 *
	 * @return User with provided username
	 *
	 * @throws ResourceNotFoundException if user with provided username does not exist
	 */
	User get(String username) throws ResourceNotFoundException;

	/**
	 * Gets all users
	 *
	 * @return a list of all users or empty list if there are no user entries
	 */
	List<User> list();
	

}