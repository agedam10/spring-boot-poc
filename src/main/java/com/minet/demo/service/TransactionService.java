package com.minet.demo.service;

import com.minet.demo.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransactionsByCustomer(int customerId);

    public void addTransaction(Transaction transaction);
}
