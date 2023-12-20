package com.jfecm.springtransactions.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource with ID " + id + " not found. This resource may have been deleted or does not exist.");
    }
}
