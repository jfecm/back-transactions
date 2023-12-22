package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Base service interface for managing entities.
 *
 * @param <E> The type of entity.
 * @param <I> The type of entity ID.
 */
public interface BaseService<E extends BaseEntity, I extends Serializable> {

    /**
     * Find an entity by its ID.
     *
     * @param id The ID of the entity to find.
     * @return The entity with the specified ID, or {@code null} if not found.
     */
    E findById(I id);

    /**
     * Retrieve all entities.
     *
     * @return A list of all entities.
     */
    List<E> findAll();

    /**
     * Save a new entity.
     *
     * @param entity The entity to save.
     * @return The saved entity.
     */
    E save(E entity);

    /**
     * Update an entity by its ID.
     *
     * @param id     The ID of the entity to update.
     * @param entity The updated entity.
     * @return The updated entity, or {@code null} if the entity with the specified ID was not found.
     */
    E updateById(I id, E entity);

    /**
     * Delete an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     * @return {@code true} if the entity was successfully deleted, {@code false} otherwise.
     */
    Boolean deleteById(I id);

}
