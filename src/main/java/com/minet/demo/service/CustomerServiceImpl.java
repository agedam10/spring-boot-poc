package com.minet.demo.service;

import com.minet.demo.dao.CustomerRepository;
import com.minet.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public Customer findCustomerById(int customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}
