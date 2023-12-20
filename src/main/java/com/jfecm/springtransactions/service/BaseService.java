package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity, I extends Serializable> {
    E findById(I id);
    List<E> findAll();
    E save(E entity);
    E updateById(I id, E entity);
    Boolean deleteById(I id);
}
