package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.model.Transaction;

public interface CustomerService extends BaseService<Customer, Long> {

    void addTransactionToCustomer(Customer customer, Transaction transaction);
}
