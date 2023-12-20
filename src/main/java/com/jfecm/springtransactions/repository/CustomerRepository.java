package com.jfecm.springtransactions.repository;

import com.jfecm.springtransactions.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
}
