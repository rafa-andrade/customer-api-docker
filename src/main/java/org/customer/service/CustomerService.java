package org.customer.service;

import lombok.extern.log4j.Log4j;
import org.customer.entity.Customer;
import org.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(final String customerId) {
        return customerRepository.findOne(customerId);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
