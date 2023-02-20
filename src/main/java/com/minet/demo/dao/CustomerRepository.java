package com.minet.demo.dao;

import com.minet.demo.entity.Asset;
import com.minet.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findCustomerById(int id);

}
