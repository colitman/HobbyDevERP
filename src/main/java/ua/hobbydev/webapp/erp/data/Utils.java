/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data;

import ua.hobbydev.webapp.erp.domain.EntityConfigurationException;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;
import ua.hobbydev.webapp.erp.domain.NamedEntityInterface;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Convenient utility methods
 */
public class Utils {

	/**
	 * Gets the alias for the entity column that contains entity name
	 *
	 * @param clazz entity class
	 *
	 * @return column alias
	 *
	 * @throws EntityConfigurationException if none of the entity columns is annotated with {@link NameColumn} annotation
     */
	static String resolveNameColumnAlias(Class<? extends NamedEntityInterface> clazz) {
		boolean fieldFound = false;
		Field field = null;
		String alias = null; 
		
		for(Field f:clazz.getDeclaredFields()) {
			if(f.isAnnotationPresent(NameColumn.class)) {
				field = f;
				fieldFound = true;
				break;
			}
		}
		
		if(fieldFound) {
			alias = field.getName();
			return alias;
		}

		throw new EntityConfigurationException(clazz.getSimpleName() + " does not have the NAME property marked.");
	}

	/**
	 * Gets the alias for the entity column that contains entity ID
	 *
	 * @param clazz entity class
	 *
	 * @return column alias
	 *
	 * @throws EntityConfigurationException if none of the entity columns is annotated with {@link Id} annotation
	 */
	static String resolveKeyColumnAlias(Class<? extends IdentifiedEntityInterface> clazz) {
		boolean fieldFound = false;
		Field field = null;
		String alias = null;
		
		for(Field f:clazz.getDeclaredFields()) {
			if(f.isAnnotationPresent(Id.class)) {
				field = f;
				fieldFound = true;
				break;
			}
		}
		
		if(fieldFound) {
			alias = field.getName();
			return alias;
		}

		throw new EntityConfigurationException(clazz.getSimpleName() + " does not have the ID property marked.");
	}
}
