package com.minet.demo.controller;

import com.minet.demo.entity.Portfolio;
import com.minet.demo.service.PortfolioService;
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

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PortfolioController.class)
public class PortFolioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortfolioService portfolioService;

    @Test
    public void testGetPortfolioForCustomer() {
        Portfolio portfolio = Portfolio.builder()
                .convertedAmount(1)
                .assetId(1)
                .conversionFactor(100)
                .assetAmount(1)
                .customerId(1)
                .build();
        List<Portfolio> portfolioList = new ArrayList<>();
        portfolioList.add(portfolio);
        given(portfolioService.getPortFolioByCustomerId(1)).willReturn(portfolioList);
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/portfolio/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$[0].customerId").value(portfolio.getCustomerId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
