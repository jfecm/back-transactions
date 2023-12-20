package com.jfecm.springtransactions.service;

import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.repository.BaseRepository;
import com.jfecm.springtransactions.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements CustomerService {

    private final CustomerRepository customerRepository;

    protected CustomerServiceImpl(BaseRepository<Customer, Long> baseRepository, CustomerRepository customerRepository) {
        super(baseRepository);
        this.customerRepository = customerRepository;
    }

}
