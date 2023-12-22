package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.graphql.inputs.InputSaveTransaction;
import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.model.Transaction;
import com.jfecm.springtransactions.model.TransactionStatus;
import com.jfecm.springtransactions.repository.BaseRepository;
import com.jfecm.springtransactions.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Long> implements TransactionService {

    private final TransactionRepository transactionRepository;

    protected TransactionServiceImpl(BaseRepository<Transaction, Long> baseRepository, TransactionRepository transactionRepository) {
        super(baseRepository);
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Customer customer, InputSaveTransaction input) {
        return Transaction.builder()
                .createdDate(LocalDateTime.now())
                .startDate(LocalDateTime.now())
                .status(TransactionStatus.PENDING)
                .amount(input.amount())
                .currencyFrom(input.currencyFrom())
                .currencyTo(input.currencyTo())
                .customer(customer)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
        return transactionRepository.findByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByStartDateBetween(startDate, endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getTotalTransactionsByCustomer(Long customerId) {
        return transactionRepository.countByCustomer_Id(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction getLatestTransactionByCustomer(Long customerId) {
        return transactionRepository.findFirstByCustomer_IdOrderByStartDateDesc(customerId);
    }
}
