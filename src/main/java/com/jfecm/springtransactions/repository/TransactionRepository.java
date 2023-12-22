package com.jfecm.springtransactions.repository;

import com.jfecm.springtransactions.model.Transaction;
import com.jfecm.springtransactions.model.TransactionStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
    Transaction findFirstByCustomer_IdOrderByStartDateDesc(Long customerId);

    Integer countByCustomer_Id(Long customerId);

    List<Transaction> findByStatus(TransactionStatus status);

    List<Transaction> findByStartDateBetween(LocalDateTime startDate, LocalDateTime startDate2);
}
