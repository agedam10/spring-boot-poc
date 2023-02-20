package com.minet.demo.repository;


import com.minet.demo.dao.WalletRepository;
import com.minet.demo.entity.Wallet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WalletRepositoryTest {
    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void updateWalletTest() {
        Wallet wallet = Wallet.builder()
                .runningBalance(232)
                .customerId(1)
                .build();
        entityManager.persist(wallet);
        entityManager.flush();
        walletRepository.updateWallet(1,2312.232F);
        entityManager.refresh(wallet);
        Assertions.assertEquals(walletRepository.findWalletByCustomerId(1).getRunningBalance(), 2312.232F);
    }

    @Test
    public void findWalletByCustomerIdTest() {
        Wallet wallet = Wallet.builder()
                .runningBalance(232)
                .customerId(1)
                .build();
        entityManager.persist(wallet);
        entityManager.flush();
        Assertions.assertEquals(walletRepository.findWalletByCustomerId(1).getCustomerId(), 1);
    }

}
