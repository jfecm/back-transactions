package com.jfecm.springtransactions.exceptions;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleResourceNotFoundExceptionGraph(ResourceNotFoundException ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException e) {
        return createErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(), "ResourceNotFoundException");
    }

    private ProblemDetail createErrorResponse(HttpStatus status, String detailMessage, String title) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detailMessage);
        problemDetail.setTitle(title);
        problemDetail.setType(URI.create("https://jfecm-errors.com/something-not-found"));
        return problemDetail;
    }

}
