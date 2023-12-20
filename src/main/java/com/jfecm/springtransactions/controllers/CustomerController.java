package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.service.CustomerService;
import com.jfecm.springtransactions.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController extends BaseControllerImpl<Customer, CustomerServiceImpl> {

    private final CustomerService customerService;

    protected CustomerController(CustomerServiceImpl baseService, CustomerService customerService) {
        super(baseService);
        this.customerService = customerService;
    }
}
