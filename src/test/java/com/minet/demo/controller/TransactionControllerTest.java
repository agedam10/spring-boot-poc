package com.minet.demo.controller;

import com.minet.demo.entity.Portfolio;
import com.minet.demo.entity.Transaction;
import com.minet.demo.entity.Wallet;
import com.minet.demo.service.PortfolioService;
import com.minet.demo.service.TransactionService;
import com.minet.demo.service.WalletService;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private WalletService walletService;

    @MockBean
    private PortfolioService portfolioService;

    @Test
    public void testGetTransactions() {
        String dateString = "2012-04-25T18:25:43.511Z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);

        Transaction transaction = Transaction.builder()
                .transactionFee(0.001F)
                .transactionType("buy")
                .transactionAmount(1)
                .customerId(1)
                .conversionFactor(100)
                .date(date)
                .convertedAmount(1)
                .fromAccount(1)
                .assetId(1)
                .paymentMethod("default")
                .toAccount(2)
                .build();

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        given(transactionService.getAllTransactionsByCustomer(1)).willReturn(transactionList);
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$[0].customerId").value(transaction.getCustomerId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddTransaction() {
        String dateString = "2012-04-25T18:25:43.511Z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);

        Transaction transaction = Transaction.builder()
                .transactionFee(0.001F)
                .transactionType("buy")
                .transactionAmount(1)
                .customerId(1)
                .conversionFactor(100)
                .date(date)
                .convertedAmount(1)
                .fromAccount(1)
                .assetId(1)
                .paymentMethod("default")
                .toAccount(2)
                .build();

        Wallet wallet = Wallet.builder()
                .runningBalance(232)
                .customerId(1)
                .build();

        Portfolio portfolio = Portfolio.builder()
                .convertedAmount(1)
                .assetId(1)
                .conversionFactor(100)
                .assetAmount(1)
                .customerId(1)
                .build();
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet);
        List<Portfolio> portfolioList = new ArrayList<>();
        portfolioList.add(portfolio);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        given(walletService.findWalletByCustomerId(1)).willReturn(wallet);
        given(portfolioService.getPortFolioByCustomerId(1)).willReturn(portfolioList);
        given(transactionService.getAllTransactionsByCustomer(1)).willReturn(transactionList);

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction")
                            .content(transaction.toString())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect((ResultMatcher) jsonPath("$").value(transaction));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
