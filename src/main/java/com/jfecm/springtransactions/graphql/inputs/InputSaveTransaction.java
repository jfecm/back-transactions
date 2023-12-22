package com.jfecm.springtransactions.graphql.inputs;

/**
 * Represents input data for saving a transaction.
 * This record includes the following fields:
 * - {@code amount}: The amount of the transaction.
 * - {@code currencyFrom}: The currency from which the amount is transferred.
 * - {@code currencyTo}: The currency to which the amount is transferred.
 */
public record InputSaveTransaction(
        Float amount,
        String currencyFrom,
        String currencyTo
) {
}
