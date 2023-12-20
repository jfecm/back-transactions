package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.model.BaseEntity;
import com.jfecm.springtransactions.service.BaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends BaseEntity, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    protected S baseService;

    protected BaseControllerImpl(S baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.findAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.findById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<?> save(@RequestBody E body) {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.save(body));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E body) {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.updateById(id, body));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(baseService.deleteById(id));
    }
}
