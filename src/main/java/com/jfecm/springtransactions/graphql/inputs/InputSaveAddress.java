package com.jfecm.springtransactions.graphql.inputs;

/**
 * Represents input data for saving an address.
 * This record includes the following fields:
 * - {@code street}: The street name of the address.
 * - {@code city}: The city of the address.
 * - {@code country}: The country of the address.
 * - {@code postalCode}: The postal code of the address.
 */
public record InputSaveAddress (
        String street,
        String city,
        String country,
        String postalCode
) {

}
