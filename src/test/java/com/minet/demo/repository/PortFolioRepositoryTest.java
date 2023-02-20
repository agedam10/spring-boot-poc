package com.minet.demo.repository;


import com.minet.demo.dao.AssetRepository;
import com.minet.demo.dao.CustomerRepository;
import com.minet.demo.dao.PortfolioRepository;
import com.minet.demo.entity.Portfolio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PortFolioRepositoryTest {

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AssetRepository assetRepository;


    @Test
    public void getPortFolioByCustomerIdTest() {
        Portfolio portfolio = Portfolio.builder()
                .convertedAmount(1)
                .assetId(1)
                .conversionFactor(100)
                .assetAmount(1)
                .customerId(1)
                .build();
        entityManager.persist(portfolio);
        entityManager.flush();
        for (Portfolio portfolios: portfolioRepository.getPortfoliosByCustomerId(1)) {
            Assertions.assertEquals(portfolios.getCustomerId(),1);
        }
    }

    @Test
    public void updatePortFolioByCustomerIdTest() {
        Portfolio portfolio = Portfolio.builder()
                .convertedAmount(1)
                .assetId(1)
                .conversionFactor(100)
                .assetAmount(1)
                .customerId(1)
                .build();
        entityManager.persist(portfolio);
        entityManager.flush();
        portfolioRepository.updateRepository(2,2,1);
        entityManager.refresh(portfolio);
        for (Portfolio portfolios: portfolioRepository.getPortfoliosByCustomerId(1)) {
            if(portfolios.getAssetId() == 1) {
                Assertions.assertEquals(portfolios.getAssetAmount(),2);
                Assertions.assertEquals(portfolios.getConvertedAmount(),2);
            }
        }
    }


}
