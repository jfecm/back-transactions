package com.jfecm.springtransactions.graphql.inputs;

/**
 * Represents input data for saving a customer.
 * This record includes the following fields:
 * - {@code name}: The name of the customer.
 * - {@code lastName}: The last name of the customer.
 * - {@code documentNumber}: The unique document number associated with the customer.
 * - {@code email}: The unique email address of the customer.
 * - {@code dateOfBirth}: The date of birth of the customer.
 * - {@code address}: The address associated with the customer.
 */
public record InputSaveCustomer (
        String name,

        String lastName,

        String documentNumber,

        String email,

        String dateOfBirth,

        InputSaveAddress address
) {

}
