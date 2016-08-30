/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.domain;

/**
 * Designates a persistent entity that has a name.
 */
public interface NamedEntityInterface extends IdentifiedEntityInterface {
	/**
	 * Gets entity name
	 * @return name of the entity
     */
	String getName();

	/**
	 * Sets entity name
	 * @param name name to set for the entity
     */
	void setName(String name);
}
