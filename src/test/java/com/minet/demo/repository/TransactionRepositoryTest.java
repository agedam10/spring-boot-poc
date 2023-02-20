package com.minet.demo.repository;

import com.minet.demo.dao.TransactionRepository;
import com.minet.demo.entity.Transaction;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void getAllTransactionsByCustomerIdTest() {
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
        entityManager.persist(transaction);
        entityManager.flush();
        List<Transaction> transactions = transactionRepository.getTransactionsByCustomerId(1);
        for(Transaction transaction1: transactions) {
            Assertions.assertEquals(transaction,transaction1);
        }
    }
}
