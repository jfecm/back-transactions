package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController extends BaseControllerImpl<Customer, CustomerServiceImpl> {

    protected CustomerController(CustomerServiceImpl baseService) {
        super(baseService);
    }
}
