package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.exceptions.ResourceNotFoundException;
import com.jfecm.springtransactions.model.BaseEntity;
import com.jfecm.springtransactions.repository.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity, I extends Serializable> implements BaseService<E, I> {
    protected BaseRepository<E, I> baseRepository;

    protected BaseServiceImpl(BaseRepository<E, I> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(I id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException((Long) id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    @Transactional
    public E save(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    @Transactional
    public E updateById(I id, E entity) {
        Optional<E> e = baseRepository.findById(id);

        return e.map(existingEntity -> baseRepository.save(entity))
                .orElseThrow(() -> new ResourceNotFoundException((Long) id));
    }

    @Override
    @Transactional
    public Boolean deleteById(I id) {
        Optional<E> e = baseRepository.findById(id);

        if (e.isPresent()) {
            baseRepository.delete(e.get());
            return true;
        }

        return false;
    }
}
