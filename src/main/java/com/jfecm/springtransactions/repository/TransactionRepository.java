package com.jfecm.springtransactions.repository;

import com.jfecm.springtransactions.model.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}
