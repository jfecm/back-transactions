package com.jfecm.springtransactions.exceptions;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleResourceNotFoundException(ResourceNotFoundException ex) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }


}
