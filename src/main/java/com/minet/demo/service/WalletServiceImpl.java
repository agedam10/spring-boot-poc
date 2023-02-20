package com.minet.demo.service;

import com.minet.demo.dao.WalletRepository;
import com.minet.demo.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletServiceImpl implements WalletService{
    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet findWalletByCustomerId(int customerId) {
        return walletRepository.findWalletByCustomerId(customerId);
    }

    @Override
    @Transactional
    public void saveOrUpdateWallet(float runningBalance, int customerId) {
        walletRepository.updateWallet(customerId, runningBalance);
    }


}
