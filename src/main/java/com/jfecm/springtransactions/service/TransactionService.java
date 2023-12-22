package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.graphql.inputs.InputSaveTransaction;
import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.model.Transaction;
import com.jfecm.springtransactions.model.TransactionStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService extends BaseService<Transaction, Long> {

    /**
     * Create and Retrieve a transaction.
     * @param customer all data for customer.
     * @param input all data for transaction.
     * @return Transaction response.
     */
    Transaction createTransaction(Customer customer, InputSaveTransaction input);

    /**
     * Retrieve all transactions.
     *
     * @return A list of all transactions.
     */
    List<Transaction> getAllTransactions();

    /**
     * Retrieve transactions by status.
     *
     * @param status The status of transactions to retrieve.
     * @return A list of transactions with the specified status.
     */
    List<Transaction> getTransactionsByStatus(TransactionStatus status);

    /**
     * Retrieve transactions within a specified date range.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A list of transactions within the specified date range.
     */
    List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Get the total number of transactions for a specific customer.
     *
     * @param customerId The ID of the customer.
     * @return The total number of transactions for the customer.
     */
    Integer getTotalTransactionsByCustomer(Long customerId);

    /**
     * Get the latest transaction for a specific customer.
     *
     * @param customerId The ID of the customer.
     * @return The latest transaction for the customer.
     */
    Transaction getLatestTransactionByCustomer(Long customerId);

}
