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

public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<Orders> getOrders(@PathVariable("id") long id) {
        Optional<Orders> orders = ordersRepository.findById(id);

        if (orders.isPresent()) {
            return new ResponseEntity<>(orders.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/orders/")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersRepository.findAll();

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
        }
    }

    @PostMapping("/api/orders/add")
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        Orders _orders = ordersRepository
                .save(new Orders(orders.getShipped_location(), orders.getPurchased_total()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
