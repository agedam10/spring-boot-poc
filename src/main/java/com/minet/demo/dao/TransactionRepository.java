package com.minet.demo.dao;

import com.minet.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> getTransactionsByCustomerId(int customerId);

}
