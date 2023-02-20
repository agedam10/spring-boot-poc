package com.minet.demo.controller;

import com.minet.demo.entity.Transaction;
import com.minet.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/transactions/{customerId}")
    public List<Transaction> getTransactions(@PathVariable int customerId) {
        return transactionService.getAllTransactionsByCustomer(customerId);
    }

    @PostMapping("/transaction")
    public void addTransaction(@RequestBody Transaction transaction) {
        transaction.setId(0);
        transactionService.addTransaction(transaction);
    }

}
