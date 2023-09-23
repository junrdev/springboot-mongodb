package com.junrdev.datamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    Customer getCustomerById(String id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    List<Customer> getCustomers() {
        return repository.findAll();
    }

    String createCustomer(CustomerDTO dto) {
        Customer customer = Customer.builder().firstName(dto.getFirstName()).lastName(dto.getLastName()).build();

        Customer saved = repository.save(customer);

        return saved.getId();
    }


}
