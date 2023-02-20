package com.minet.demo.service;

import com.minet.demo.dao.TransactionRepository;
import com.minet.demo.entity.Portfolio;
import com.minet.demo.entity.Transaction;
import com.minet.demo.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    private TransactionRepository transactionRepository;
    private WalletService walletService;
    private PortfolioService portfolioService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, WalletService walletService, PortfolioService portfolioService) {
        this.transactionRepository = transactionRepository;
        this.walletService = walletService;
        this.portfolioService = portfolioService;
    }

    @Override
    public List<Transaction> getAllTransactionsByCustomer(int customerId) {
        return transactionRepository.getTransactionsByCustomerId(customerId);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        Wallet customerWallet = walletService.findWalletByCustomerId(transaction.getCustomerId());
        Portfolio portfolioAssetInfo = null;
        if ("buy".equals(transaction.getTransactionType())) {
            Portfolio portfolio = Portfolio.builder()
                    .convertedAmount(transaction.getConvertedAmount())
                    .assetId(transaction.getAssetId())
                    .conversionFactor(transaction.getConversionFactor())
                    .assetAmount(transaction.getTransactionAmount())
                    .customerId(transaction.getCustomerId())
                    .build();
            portfolioService.savePortfolio(portfolio);
        }
        List<Portfolio> portfolioList = portfolioService.getPortFolioByCustomerId(transaction.getCustomerId());
        for (Portfolio portfolio: portfolioList) {
            if(portfolio.getAssetId() == transaction.getAssetId()) {
                portfolioAssetInfo = portfolio;
            }
        }


        if (transaction.getTransactionType().equals("buy") && (customerWallet.getRunningBalance() != 0 )) {
            if (customerWallet.getRunningBalance() > transaction.getConvertedAmount()) {
                transactionRepository.save(transaction);
                walletService.saveOrUpdateWallet(customerWallet.getRunningBalance()-transaction.getConvertedAmount(), customerWallet.getCustomerId());
                portfolioService.saveOrUpdatePortfolio(transaction.getTransactionAmount() + portfolioAssetInfo.getAssetAmount(),transaction.getConvertedAmount() - transaction.getTransactionFee() + portfolioAssetInfo.getConvertedAmount(), transaction.getAssetId());
            }
        } else if (transaction.getTransactionType().equals("sell") && transaction.getTransactionAmount()>0) {
            if (portfolioAssetInfo.getAssetAmount() > 0 ) {
                transactionRepository.save(transaction);
                walletService.saveOrUpdateWallet(customerWallet.getRunningBalance() + transaction.getConvertedAmount(), customerWallet.getCustomerId());
                portfolioService.saveOrUpdatePortfolio(transaction.getTransactionAmount() - portfolioAssetInfo.getAssetAmount(), portfolioAssetInfo.getConvertedAmount() - transaction.getConvertedAmount() - transaction.getTransactionFee(), transaction.getAssetId());
            }
        }
    }
}
