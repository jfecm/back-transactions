package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.graphql.inputs.InputSaveTransaction;
import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.model.Transaction;
import com.jfecm.springtransactions.model.TransactionStatus;
import com.jfecm.springtransactions.service.CustomerService;
import com.jfecm.springtransactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphQLTransactionController {
    private final CustomerService customerService;
    private final TransactionService transactionService;

    @MutationMapping(name = "saveTransaction")
    public Transaction save(@Argument(name = "customerId") String id,
                            @Argument(name = "input") InputSaveTransaction input) {
        Customer customer = customerService.findById(Long.parseLong(id));
        Transaction transaction = transactionService.createTransaction(customer, input);
        customerService.addTransactionToCustomer(customer, transaction);
        return transaction;
    }

    @QueryMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @QueryMapping
    public List<Transaction> getTransactionsByStatus(@Argument(name = "status") TransactionStatus status) {
        return transactionService.getTransactionsByStatus(status);
    }

    @QueryMapping
    public List<Transaction> getTransactionsByDateRange(
            @Argument(name = "startDate") String startDate,
            @Argument(name = "endDate") String endDate) {
        return transactionService.getTransactionsByDateRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
    }

    @QueryMapping
    public Integer getTotalTransactionsByCustomer(@Argument(name = "customerId") Long customerId) {
        return transactionService.getTotalTransactionsByCustomer(customerId);
    }

    @QueryMapping
    public Transaction getLatestTransactionByCustomer(@Argument(name = "customerId") Long customerId) {
        return transactionService.getLatestTransactionByCustomer(customerId);
    }

}
