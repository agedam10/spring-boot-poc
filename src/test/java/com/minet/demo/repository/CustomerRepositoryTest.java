package com.minet.demo.repository;

import com.minet.demo.dao.CustomerRepository;
import com.minet.demo.entity.Asset;
import com.minet.demo.entity.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void getCustomerByIdTest() {
        Customer customer = Customer.builder()
                .firstName("Aniket")
                .portfolioId(1)
                .profilePicture("wewa.png")
                .walletId(1)
                .lastName("Gedam")
                .watchlistId(1)
                .build();
        entityManager.persist(customer);
        entityManager.flush();
        Assertions.assertEquals(customerRepository.findCustomerById(1).getId(), 1);
    }
}
