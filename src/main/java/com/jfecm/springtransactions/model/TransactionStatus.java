package com.jfecm.springtransactions.model;

/**
 * Represents the status of a transaction.
 * Possible values:
 * - {@code PENDING}: The transaction is pending and has not been completed.
 * - {@code COMPLETED}: The transaction has been successfully completed.
 * - {@code REJECTED}: The transaction has been rejected and was not completed.
 */
public enum TransactionStatus {
    PENDING,
    COMPLETED,
    REJECTED
}
