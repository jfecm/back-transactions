package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.model.Transaction;
import com.jfecm.springtransactions.service.TransactionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/transactions")
public class TransactionController extends BaseControllerImpl<Transaction, TransactionServiceImpl> {

    protected TransactionController(TransactionServiceImpl baseService) {
        super(baseService);
    }

}
