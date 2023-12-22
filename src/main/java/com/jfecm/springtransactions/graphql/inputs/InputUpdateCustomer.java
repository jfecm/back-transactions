package com.jfecm.springtransactions.graphql.inputs;

/**
 * Represents input data for updating a customer's name.
 * This record includes the following field:
 * - {@code name}: The updated name of the customer.
 */
public record InputUpdateCustomer(

        String name

) {

}