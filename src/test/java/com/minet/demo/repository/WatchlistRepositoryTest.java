package com.minet.demo.repository;

import com.minet.demo.dao.WalletRepository;
import com.minet.demo.dao.WatchlistRepository;
import com.minet.demo.entity.Watchlist;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WatchlistRepositoryTest {
    @Autowired
    WatchlistRepository watchlistRepository;

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void findWatchlistByCustomerIdTest() {
        Watchlist watchlist = Watchlist.builder()
                .customerId(1)
                .assetId(1)
                .build();
        entityManager.persist(watchlist);
        entityManager.flush();
        List<Watchlist> watchlistList = watchlistRepository.findByCustomerId(1);
        for(Watchlist watchlist1: watchlistList) {
            Assertions.assertEquals(watchlist1.getCustomerId(),1);
        }
    }
}
