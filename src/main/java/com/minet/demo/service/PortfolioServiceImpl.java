package com.minet.demo.service;

import com.minet.demo.dao.PortfolioRepository;
import com.minet.demo.entity.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService{
    private PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    @Transactional
    public List<Portfolio> getPortFolioByCustomerId(int customerId) {
        return portfolioRepository.getPortfoliosByCustomerId(customerId);
    }

    @Transactional
    @Override
    public void saveOrUpdatePortfolio(float assetAmount, float convertedAmount, int assetId) {
        portfolioRepository.updateRepository(assetAmount, convertedAmount, assetId);
    }

    @Transactional
    @Override
    public void savePortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }


}
