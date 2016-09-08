/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.hobbydev.webapp.erp.domain.EntityInterface;
import ua.hobbydev.webapp.erp.domain.IdentifiedEntityInterface;
import ua.hobbydev.webapp.erp.domain.NamedEntityInterface;
import ua.hobbydev.webapp.erp.domain.UniqueNamedEntityInterface;

import java.util.Collections;
import java.util.List;

/**
 * Generic class for accessing application datastorage
 */
@Repository
public class DefaultDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Checks whether the entity with provided key exists
	 *
	 * @param clazz entity class
	 * @param key key to check
     * @return true is entity of the provided class with provided key exists; false otherwise
     */
	public <ENTITY extends IdentifiedEntityInterface> boolean exists(Class<ENTITY> clazz, Long key) {
		
		if(key == null) {
			return false;
		}
		
		Session session = getSession();
		
		ENTITY entity = session.get(clazz, key);
		
		return entity != null;
	}

	/**
	 * Gets key of the entity with provided name
	 *
	 * @param clazz entity class
	 * @param name name to discover a key
	 *
	 * @return ID of the entity of the provided class with provided name.
	 *
	 * @throws ObjectNotExistsException if entity of provided class with provided name does not exist.
	 * @throws IllegalArgumentException if provided name id NULL
     */
	public <ENTITY extends UniqueNamedEntityInterface> Long getKeyByName(Class<ENTITY> clazz, String name) throws ObjectNotExistsException {
		if (name == null) {
			throw new IllegalArgumentException("Invalid value for entity name provided:[NULL]");
		}
		
		String nameColumnAlias = Utils.resolveNameColumnAlias(clazz);
		String keyColumnAlias = Utils.resolveKeyColumnAlias(clazz);
		
		Session session = getSession();
		Long id = (Long) session.createCriteria(clazz)
							.add(Restrictions.eq(nameColumnAlias, name))
							.setProjection(Projections.property(keyColumnAlias))
							.uniqueResult();
		
		if(id == null) {
			throw new ObjectNotExistsException(clazz.getSimpleName() + " entity with requested name does not exist:[" + name + "]");
		}
		
		return id;
	}

	/**
	 * Gets a list of keys of entities with provided name
	 *
	 * @param clazz entity class
	 * @param name name to discover keys
	 *
	 * @return List of IDs of entities of the provided class with provided name.
	 * Returns empty list if there are no entities of provided class with provided name
	 *
	 * @throws IllegalArgumentException if provided name id NULL
	 */
	public <ENTITY extends NamedEntityInterface> List<Long> getKeysByName(Class<ENTITY> clazz, String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid value for entity name provided:[NULL]");
		}
		
		String nameColumnAlias = Utils.resolveNameColumnAlias(clazz);
		String keyColumnAlias = Utils.resolveKeyColumnAlias(clazz);
		
		Session session = getSession();

		@SuppressWarnings("unchecked")
		List<Long> ids = session.createCriteria(clazz)
									.add(Restrictions.eq(nameColumnAlias, name))
									.setProjection(Projections.property(keyColumnAlias))
									.list();
		
		if(ids == null) {
			ids = Collections.emptyList();
		}
		
		return ids;
	}

	/**
	 * Gets an entity by key
	 *
	 * @param clazz entity class
	 * @param key key to search
	 *
	 * @return Entity of the provided class with provided ID
	 *
	 * @throws ObjectNotExistsException if entity of provided class with provided ID does not exist
	 * @throws IllegalArgumentException if provided key id NULL
     */
	public <ENTITY extends IdentifiedEntityInterface> ENTITY getByKey(Class<ENTITY> clazz, Long key) throws ObjectNotExistsException {
		if (key == null) {
			throw new IllegalArgumentException("Invalid value for entity key provided:[NULL]");
		}
		
		if(!exists(clazz, key)) {
			throw new ObjectNotExistsException(clazz.getSimpleName() + " entity with requested key does not exist:[" + key.toString() + "]");
		}
		
		Session session = getSession();
		
		ENTITY entity = session.load(clazz, key);
		return entity;
	}

	/**
	 * Gets all entities of the provided class
	 * @param clazz entity class
	 *
     * @return a list of all entities of provided class or empty list if there no such entities
     */
	public <ENTITY extends EntityInterface> List<ENTITY> getAll(Class<ENTITY> clazz) {
		Session session = getSession();
		
		@SuppressWarnings("unchecked")
		List<ENTITY> entities = session.createCriteria(clazz).list();
		
		if(entities == null) {
			entities = Collections.emptyList();
		}
		
		return entities;
	}

	/**
	 * Creates a new entry in the datastorage with data from provided entity
	 *
	 * @param entity entity information to save
	 *
     * @return ID of the newly created entity
     */
	public <ENTITY extends EntityInterface> Long create(ENTITY entity) {
		Session session = getSession();

		Long key = -1L;

		try {
			key = (Long) session.save(entity);
		} catch (ClassCastException cce) {
			// TODO add logging
		}
		
		return key;
	}

	/**
	 * Updates entry information in datastorage by ID of the provided entity.
	 * @param entity entity information to update datastorage with.
	 *
	 * @return true if entity was updated; false otherwise
	 *
	 * @throws ObjectNotExistsException if ID of the provided entity is NULL or there is no saved entry
	 * for entity with ID, equal to ID of the provided entity.
	 * @throws IllegalArgumentException if provided entity is NULL
     */
	public <ENTITY extends IdentifiedEntityInterface> boolean update(ENTITY entity) throws ObjectNotExistsException {
		if(entity == null) {
			throw new IllegalArgumentException("Invalid entity provided:[NULL]");
		}
		
		if(entity.getKey() == null || !exists(entity.getClass(), entity.getKey())) {
			throw new ObjectNotExistsException(entity.getClass().getSimpleName() + " entity, requested for update does not exist");
		}
		
		Session session = getSession();

		return session.merge(entity) != null;
	}

	public <ENTITY extends IdentifiedEntityInterface> void delete(ENTITY entity) {
		if(entity == null || entity.getKey() == null) {
			throw new IllegalArgumentException("Invalid entity provided - entity or its key is NULL");
		}

		if(!exists(entity.getClass(), entity.getKey())) {
			return;
		}

		Session session = getSession();
		session.delete(entity);
	}
}
