package com.jfecm.springtransactions.graphql.inputs;

public record InputSaveCustomer(
        String name,

        String lastName,

        String documentNumber,

        String email,

        String dateOfBirth

) {

}
