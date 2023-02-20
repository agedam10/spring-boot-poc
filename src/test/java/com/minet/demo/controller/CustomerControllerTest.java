package com.minet.demo.controller;


import com.minet.demo.entity.Customer;
import com.minet.demo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetCustomerById() {
        Customer customer = Customer.builder()
                .firstName("Aniket")
                .portfolioId(1)
                .profilePicture("wewa.png")
                .walletId(1)
                .lastName("Gedam")
                .watchlistId(1)
                .id(1)
                .build();
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        given(customerService.findCustomerById(1)).willReturn(customers.get(0));
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$.id").value(customer.getId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
