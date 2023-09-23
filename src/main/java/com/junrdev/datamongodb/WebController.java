package com.junrdev.datamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/customers")
public class WebController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PostMapping("/new")
    public @ResponseBody String createCustomer(@RequestBody CustomerDTO dto){
        return service.createCustomer(dto);
    }


}
