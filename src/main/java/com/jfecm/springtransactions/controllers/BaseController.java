package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.model.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends BaseEntity, I extends Serializable> {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(@PathVariable I id);
    ResponseEntity<?> save(@RequestBody E body);
    ResponseEntity<?> update(@PathVariable I id, @RequestBody E body);
    ResponseEntity<?> deleteById(@PathVariable I id);
}
