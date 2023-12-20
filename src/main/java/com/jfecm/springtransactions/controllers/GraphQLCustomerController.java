package com.jfecm.springtransactions.controllers;

import com.jfecm.springtransactions.graphql.inputs.InputSaveCustomer;
import com.jfecm.springtransactions.graphql.inputs.InputUpdateCustomer;
import com.jfecm.springtransactions.model.Customer;
import com.jfecm.springtransactions.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphQLCustomerController {

    private final CustomerService customerService;

    @QueryMapping(name = "findCustomerById")
    public Customer findById(@Argument(name = "id") String id) {
        return customerService.findById(Long.parseLong(id));
    }

    @QueryMapping(name = "findAllCustomers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @MutationMapping(name = "saveCustomer")
    public Customer save(@Argument(name = "inputCustomer") InputSaveCustomer input) {

        Customer customer = Customer.builder()
                .name(input.name())
                .lastName(input.lastName())
                .email(input.email())
                .documentNumber(input.documentNumber())
                .createdDate(LocalDateTime.now())
                .dateOfBirth(LocalDate.parse(input.dateOfBirth()))
                .build();

        return customerService.save(
                customer
        );
    }

    @MutationMapping(name = "deleteCustomerById")
    public String deleteById(@Argument(name = "id") String id) {
        Customer customer = customerService.findById(Long.parseLong(id));

        Boolean result = customerService.deleteById(customer.getId());

        if (Boolean.TRUE.equals(result)) {
            return "successfully deleted";
        }

        return "Failed to delete or not found";
    }


    @MutationMapping(name = "updateCustomerById")
    public Customer updateById(@Argument(name = "id") String id,
                               @Argument(name = "customer") InputUpdateCustomer input) {

        Customer customer = customerService.findById(Long.parseLong(id));
        customer.setName(input.name());
        customer.setLastModifiedDate(LocalDateTime.now());

        return customerService.updateById(Long.parseLong(id), customer);
    }

}

