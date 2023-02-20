package com.minet.demo.service;


import com.minet.demo.entity.Portfolio;

import java.util.List;

public interface PortfolioService {
    public List<Portfolio> getPortFolioByCustomerId(int customerId);

    public void saveOrUpdatePortfolio(float assetAmount, float convertedAmount, int assetId);
    public void savePortfolio(Portfolio portfolio);

}
