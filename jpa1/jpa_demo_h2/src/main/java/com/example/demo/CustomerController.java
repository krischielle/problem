package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/customers/")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        }
    }

    @PostMapping("/api/customers/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer _customers = customerRepository
                .save(new Customer(customer.getFirst_name(), customer.getLast_name(), customer.getDate_joined()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
