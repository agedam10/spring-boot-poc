package com.minet.demo.controller;

import com.minet.demo.entity.Portfolio;
import com.minet.demo.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PortfolioController {
    private PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping(value = "/portfolio/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Portfolio> getPortfolioForCustomer(@PathVariable int customerId) {
        return portfolioService.getPortFolioByCustomerId(customerId);
    }

}
