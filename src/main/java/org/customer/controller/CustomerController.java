package org.customer.controller;

import org.customer.entity.Customer;
import org.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findById(@PathVariable final String customerId) {
        return ResponseEntity.ok(customerService.findById(customerId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> save(@RequestBody final Customer customer) {
        return new ResponseEntity(customerService.save(customer), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> update(@PathVariable final String customerId,
                                           @RequestBody final Customer customer) {
        customer.setId(customerId);
        return ResponseEntity.ok(customerService.save(customer));
    }
}
